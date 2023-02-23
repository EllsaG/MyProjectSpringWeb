package com.myproject.utils;


import com.myproject.entity.FullInformation;
import com.myproject.entity.FullStartInformId;
import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationAlreadyExistsException;
import com.myproject.repositories.FullInformationRepository;
import com.myproject.service.startinformation.postget.StartInformationService;

import java.util.*;
import java.util.stream.Collectors;

public class ForFullTableLoadCalculation {

    public static FullInformation calculation(FullInformationRepository fullInformationRepository, StartInformationService startInformationService,
                                              Long id, String nameOfBusbar, List<FullStartInformId> fullStartInformId) {

        Optional<FullInformation> byId = fullInformationRepository.findById(id);
        if (byId.isPresent()) {
            throw new InformationAlreadyExistsException("Information about busbar with id № " + id + " is already exists");
        }

        HashMap<Long, Integer> numbersAndAmountOfEquipments = new HashMap<>();
        fullStartInformId.stream()
                .forEach((e) -> {
                    numbersAndAmountOfEquipments.put(e.getStartInformId(), e.getAmount());
                });

        List<Long> numbersOfEquipments = new ArrayList<>(numbersAndAmountOfEquipments.keySet());

        Collection<Integer> amountOfEquipments = numbersAndAmountOfEquipments.values();
        List<StartInformation> startInformationList = new ArrayList<>();


        for (int i = 0; i < numbersOfEquipments.size(); i++) {
            startInformationList.add(startInformationService.getInformationById(Long.valueOf(numbersOfEquipments.get(i))));
        }

        Integer amount = amountOfEquipments.stream().reduce((a, e) -> a + e).get(); // amount of equipment in busbar

        Double powerOfGroup = startInformationList.stream()
                .map((a) -> a.getPower() * numbersAndAmountOfEquipments.get(a.getStartInformId()))
                .reduce((a, e) -> (a + e)).get(); // active power of all groups included in the busbar


        Double avgDailyActivePower = startInformationList.stream()
                .map((a) -> a.getAvgDailyActivePower() * numbersAndAmountOfEquipments.get(a.getStartInformId()))
                .reduce((a, e) -> (a + e)).get(); // average daily active power of all groups included in the busbar

        Double avgDailyReactivePower = startInformationList.stream()
                .map((a) -> a.getAvgDailyReactivePower() * numbersAndAmountOfEquipments.get(a.getStartInformId()))
                .reduce((a, e) -> (a + e)).get(); // average daily reactive power of all groups included in the busbar


        Double module = module(startInformationList); // module of the current busbar

        Double kI = Math.round((avgDailyActivePower / powerOfGroup) * 100.0) / 100.0; // utilization factor

        Double tgF = Math.round((avgDailyReactivePower / avgDailyActivePower) * 100.0) / 100.0; // tgf

        Double cosF = Math.round(Math.sqrt(1 / (1 + Math.pow(tgF, 2))) * 100.0) / 100.0; //cosf

        Integer effectiveAmountOfEquipment = amountOfEquipments.stream()
                .reduce((a, b) -> (a + b)).get();/* effective amount of equipment (at amount≥5, kI≤0.2,m≥3 and powerOfGroup ≠ const).
                    In other values (amount, kI and powerOfGroup) the formula need to change (in the future)*/

        Double coefficientMax = kMax(kI, amount); // coefficient max of the current busbar

        Double maxActivePower = Math.round((avgDailyActivePower * coefficientMax) * 100.0) / 100.0;// max active power of the current busbar

        Double maxReactivePower = avgDailyReactivePower; /* max reactive power of the current busbar (at amount > 10)
        At amount <= 10 the formula need to change (in the future)*/

        Double maxFullPower = Math.round(Math.sqrt(Math.pow(maxActivePower, 2) +
                Math.pow(maxReactivePower, 2)) * 100.0) / 100.0; // max full power of the current busbar

        Double maxElectricCurrent = Math.round(((maxFullPower * 1000) / (Math.sqrt(3) * 380)) * 100) / 100.0; // max electric current of this busbar

        return new FullInformation(id, nameOfBusbar, amount,
                avgDailyActivePower, avgDailyReactivePower, effectiveAmountOfEquipment,
                coefficientMax, maxActivePower, maxReactivePower, maxFullPower,
                maxElectricCurrent, powerOfGroup, cosF, tgF, kI, module, fullStartInformId);

    }


    private static Double module(List<StartInformation> startInformationList) {
        List<Double> list = startInformationList.stream()
                .map((x) -> x.getPower()).collect(Collectors.toList()); // take all "power" from equipment list of the current busbar
        Double min = list.stream().min(Double::compareTo).get();
        Double max = list.stream().max(Double::compareTo).get();
        return Math.round((max / min) * 10.0) / 10.0;  // round to one argument after point
    }


    private static Double kMax(Double kI, Integer amount) {
        int b = 0; // for selection from one-dimensional arrays ( at values of kI {0 - 0.1},{0.11 - 0.2},{0.21 - 0.4})
        int j = 0; // for selection from two-dimensional arrays ( at values of amount {0-6, 7-9, 10-14, 16-20, 21-40, 41-70, 71-100, 101-160, 161-200})

        double[][] kMax = {{3.23, 2.72, 2.24, 1.91, 1.62, 1.34, 1.23, 1.17, 1.05},
                {2.42, 1.99, 1.75, 1.55, 1.34, 1.19, 1.13, 1.1, 1.06},
                {1.76, 1.52, 1.36, 1.26, 1.19, 1.12, 1.09, 1.06, 1.05}};//(it's not a full values) full values in the table from https://www.calc.ru/Raschetnaya-Nagruzka.html


        if (kI <= 0.1) {
            b = 0;
        } else if (kI <= 0.2) {
            b = 1;
        } else if (kI > 0.2) {
            b = 2;
        }

        if (amount <= 6) {
            b = 0;
        } else if (amount <= 9) {
            j = 1;
        } else if (amount <= 14) {
            j = 2;
        } else if (amount <= 20) {
            j = 3;
        } else if (amount <= 40) {
            j = 4;
        } else if (amount <= 70) {
            j = 5;
        } else if (amount <= 100) {
            j = 6;
        } else if (amount <= 160) {
            j = 7;
        } else {
            j = 8;
        } // use "else" if amount will be more than 160 \

        return Math.round((kMax[b][j]) * 100.0) / 100.0; //  round to two argument after point
    }


}
