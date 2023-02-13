package com.myproject.matching;

import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationAlreadyExistsException;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.StartInformationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class StartInformationMatching {

    public static StartInformation createIfDontExist(StartInformationRepository startInformationRepository, Long startInformId, String name, BigDecimal power, BigInteger amount) {
//        StartInformation startInformation = startInformationRepository.findById(startInformId)
//                .map((e) -> {
//                    if (e.getStartInformId() == startInformId) {
//                        throw new InformationAlreadyExistsException("Information about equipment with id № " + startInformId + " is already exists");
//                    }
//                    if (e.getName() == name) {
//                        if (e.getPower() == power) {
//                            throw new InformationAlreadyExistsException("Information about equipment with name: " + name + "and power: " + power + " is already exists");
//                        }
//                    }
//                    return new StartInformation(startInformId, name, power, amount);
//                }).stream().collect(Collectors.groupingBy());



//        return startInformation;
    }
}
