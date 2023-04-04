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

    public FullInformation calculation(FullInformationRepository fullInformationRepository, StartInformationService startInformationService,
                                              long id, String nameOfBusbar, List<FullStartInformId> fullStartInformId) {

        isExists(fullInformationRepository, id);

        HashMap<Long, Integer> numbersAndAmountOfEquipments = new HashMap<>();
        fullStartInformId.stream()
                .forEach((e) -> {
                    numbersAndAmountOfEquipments.put(e.getStartInformId(), e.getAmount());
                });

        List<Long> numbersOfEquipments = new ArrayList<>(numbersAndAmountOfEquipments.keySet());

        Collection<Integer> amountOfEquipments = numbersAndAmountOfEquipments.values();
        List<StartInformation> startInformationList = new ArrayList<>();

        List<FullStartInformId> fullStartInformIds = new ArrayList<>();


        for (int i = 0; i < numbersOfEquipments.size(); i++) {
            StartInformation informationById = startInformationService.getInformationById(Long.valueOf(numbersOfEquipments.get(i)));
            informationById.setAmount(numbersAndAmountOfEquipments.get(Long.valueOf(numbersOfEquipments.get(i))));
            FullStartInformId fullStartInformId1 = new FullStartInformId();
            fullStartInformId1.setFullInformationId(fullStartInformId.get(i).getFullInformationId());
            fullStartInformId1.setStartInformId(fullStartInformId.get(i).getStartInformId());
            fullStartInformId1.setName(informationById.getName());
            fullStartInformId1.setPower(informationById.getPower());
            fullStartInformId1.setPowerOfGroup(informationById.getPower() * informationById.getAmount());
            fullStartInformId1.setAmount(informationById.getAmount());
            fullStartInformId1.setKi(informationById.getKi());
            fullStartInformId1.setCosf(informationById.getCosf());
            fullStartInformId1.setTgf(informationById.getTgf());
            fullStartInformId1.setAvgDailyActivePower(informationById.getAvgDailyActivePower());
            fullStartInformId1.setAvgDailyReactivePower(informationById.getAvgDailyReactivePower());

            fullStartInformIds.add(fullStartInformId1);
            startInformationList.add(informationById);
        }

        int amount = amountOfEquipments.stream()
                .reduce(Integer::sum)
                .get(); // amount of equipment in busbar

        double powerOfGroup = fullStartInformIds.stream()
                .map((a) -> a.getPower() * numbersAndAmountOfEquipments.get(a.getStartInformId()))
                .reduce(Double::sum)
                .get(); // active power of all groups included in the busbar


        double avgDailyActivePower = fullStartInformIds.stream()
                .map((a) -> a.getAvgDailyActivePower() * numbersAndAmountOfEquipments.get(a.getStartInformId()))
                .reduce(Double::sum)
                .get(); // average daily active power of all groups included in the busbar

        double avgDailyReactivePower = fullStartInformIds.stream()
                .map((a) -> a.getAvgDailyReactivePower() * numbersAndAmountOfEquipments.get(a.getStartInformId()))
                .reduce(Double::sum)
                .get(); // average daily reactive power of all groups included in the busbar


        double module = module(fullStartInformIds); // module of the current busbar

        double kI = Math.round((avgDailyActivePower / powerOfGroup) * 100.0) / 100.0; // utilization factor

        double tgF = Math.round((avgDailyReactivePower / avgDailyActivePower) * 100.0) / 100.0; // tgf

        double cosF = Math.round(Math.sqrt(1 / (1 + Math.pow(tgF, 2))) * 100.0) / 100.0; //cosf

        int effectiveAmountOfEquipment;// effective amount of equipment

        if(amount>5 && kI>0.2 && module>3) {
            List<Double> list = fullStartInformIds.stream()
                    .map(FullStartInformId::getPower).collect(Collectors.toList()); // take all "power" from equipment list of the current busbar
            double maxPowerOfOne = list.stream().max(Double::compareTo)
                    .get();
            effectiveAmountOfEquipment = (int) (2*powerOfGroup/maxPowerOfOne);
        } else if(amount<5 && kI>0.2 && module>3) {
            double aDouble = fullStartInformIds.stream()
                    .map((e) -> Math.pow(e.getPower(), 2) * e.getAmount())
                    .reduce(Double::sum)
                    .get();
            effectiveAmountOfEquipment = (int) (Math.pow(powerOfGroup,2)*aDouble);
        } else{
            effectiveAmountOfEquipment = amountOfEquipments.stream()
                    .reduce(Integer::sum)
                    .get();
        }

        double coefficientMax = kMax(kI, amount); // coefficient max of the current busbar

        double maxActivePower = Math.round((avgDailyActivePower * coefficientMax) * 100.0) / 100.0;// max active power of the current busbar

        double maxReactivePower = avgDailyReactivePower; /* max reactive power of the current busbar (at amount > 10)
        At amount <= 10 the formula need to change (in the future)*/

        double maxFullPower = Math.round(Math.sqrt(Math.pow(maxActivePower, 2) +
                Math.pow(maxReactivePower, 2)) * 100.0) / 100.0; // max full power of the current busbar

        double maxElectricCurrent = Math.round(((maxFullPower * 1000) / (Math.sqrt(3) * 380)) * 100) / 100.0; // max electric current of this busbar

        return new FullInformation(id, nameOfBusbar, amount,
                avgDailyActivePower, avgDailyReactivePower, effectiveAmountOfEquipment,
                coefficientMax, maxActivePower, maxReactivePower, maxFullPower,
                maxElectricCurrent, powerOfGroup, cosF, tgF, kI, module, fullStartInformIds);

    }


    public FullInformation calculationMainBusbar(FullInformationRepository fullInformationRepository,
                                                        long id, String nameOfBusbar, List<Long> numbersBusbarsIncludedInMain) {

        isExists(fullInformationRepository, id);

        List<FullInformation> allById = fullInformationRepository.findAllById(numbersBusbarsIncludedInMain);

        int amount = allById.stream()
                .map(FullInformation::getAmount)
                .reduce(Integer::sum)
                .get(); // amount of equipment in all busbar

        double powerOfGroup = allById.stream()
                .map(FullInformation::getPowerOfGroup)
                .reduce(Double::sum)
                .get(); // active power of all groups included in the busbar


        double avgDailyActivePower = allById.stream()
                .map(FullInformation::getAvgDailyActivePower)
                .reduce(Double::sum)
                .get(); // average daily active power of all groups included in the busbar

        double avgDailyReactivePower = allById.stream()
                .map(FullInformation::getAvgDailyReactivePower)
                .reduce(Double::sum)
                .get(); // average daily reactive power of all groups included in the busbar

        List<Double> list = allById.stream()
                .map(FullInformation::getModule).collect(Collectors.toList()); // take all "power" from equipment list of the current busbar
        double min = list.stream()
                .min(Double::compareTo)
                .get();
        double max = list.stream()
                .max(Double::compareTo)
                .get();

        double module =  Math.round((max / min) * 10.0) / 10.0;  // round to one argument after point


        double kI = Math.round((avgDailyActivePower / powerOfGroup) * 100.0) / 100.0; // utilization factor

        double tgF = Math.round((avgDailyReactivePower / avgDailyActivePower) * 100.0) / 100.0; // tgf

        double cosF = Math.round(Math.sqrt(1 / (1 + Math.pow(tgF, 2))) * 100.0) / 100.0; //cosf


        int effectiveAmountOfEquipment;// effective amount of equipment

        if(amount>5 && kI>0.2 && module>3) {
            List<Double> list2 = allById.stream()
                    .map(FullInformation::getPowerOfGroup)
                    .collect(Collectors.toList()); // take all "power" from equipment list of the current busbar
            double maxPowerOfOne = list2.stream().max(Double::compareTo).get();
            effectiveAmountOfEquipment = (int) (2*powerOfGroup/maxPowerOfOne);
        } else if(amount<5 && kI>0.2 && module>3) {
            double aDouble = allById.stream()
                    .map((e) -> Math.pow(e.getPowerOfGroup(), 2) * e.getAmount())
                    .reduce(Double::sum)
                    .get();
            effectiveAmountOfEquipment = (int) (Math.pow(powerOfGroup,2)*aDouble);
        } else{
            effectiveAmountOfEquipment = allById.stream()
                    .map(FullInformation::getAmount)
                    .reduce(Integer::sum)
                    .get();
        }




        double coefficientMax = kMax(kI, amount); // coefficient max of the current busbar

        double maxActivePower = Math.round((avgDailyActivePower * coefficientMax) * 100.0) / 100.0;// max active power of the current busbar

        double maxReactivePower = avgDailyReactivePower; /* max reactive power of the current busbar (at amount > 10)
        At amount <= 10 the formula need to change (in the future)*/

        double maxFullPower = Math.round(Math.sqrt(Math.pow(maxActivePower, 2) +
                Math.pow(maxReactivePower, 2)) * 100.0) / 100.0; // max full power of the current busbar

        double maxElectricCurrent = Math.round(((maxFullPower * 1000) / (Math.sqrt(3) * 380)) * 100) / 100.0; // max electric current of this busbar

        List<FullStartInformId> list1 = new ArrayList<>();

        return new FullInformation(id, nameOfBusbar, amount,
                avgDailyActivePower, avgDailyReactivePower, effectiveAmountOfEquipment,
                coefficientMax, maxActivePower, maxReactivePower, maxFullPower,
                maxElectricCurrent, powerOfGroup, cosF, tgF, kI, module, list1);
    }


    private double module(List<FullStartInformId> fullStartInformIds) {
        List<Double> list = fullStartInformIds.stream()
                .map(FullStartInformId::getPower)
                .collect(Collectors.toList()); // take all "power" from equipment list of the current busbar
        double min = list.stream()
                .min(Double::compareTo)
                .get();
        double max = list.stream()
                .max(Double::compareTo)
                .get();
        return Math.round((max / min) * 10.0) / 10.0;  // round to one argument after point
    }


    private double kMax(double kI, int amount) {
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

    private void isExists(FullInformationRepository fullInformationRepository, Long id){
        Optional<FullInformation> byId = fullInformationRepository.findById(id);
        if (byId.isPresent()) {
            throw new InformationAlreadyExistsException("Information about busbar with id № " + id + " is already exists");
        }
    }


}
