package com.myproject.utils;

import com.myproject.entity.StartInformation;
import com.myproject.service.startinformation.postget.StartInformationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ForFullTableLoadCalculation {

    private final StartInformationService startInformationService;


    public ForFullTableLoadCalculation(StartInformationService startInformationService) {
        this.startInformationService = startInformationService;
    }

    public String calculation(Integer id, String nameOfBusbar, HashMap<Integer, Integer> numbersAndAmountOfEquipments) {
        Set<Integer> numbersOfEquipments = numbersAndAmountOfEquipments.keySet();
        Collection<Integer> amountOfEquipments = numbersAndAmountOfEquipments.values();
        List<StartInformation> startInformationList = new ArrayList<>();
        while (numbersOfEquipments.iterator().hasNext()) {
            startInformationList.add(startInformationService.getInformationById(numbersOfEquipments.iterator().next().longValue()));
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


//        StartInformation startInformation = startInformationList.stream()
//                .min((x,y) -> (int) (x.getPower() - y.getPower()))
//                .get();

    }


}
