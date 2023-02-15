package com.myproject.matching;

import com.myproject.entity.StartInformation;
import com.myproject.exceptions.InformationAlreadyExistsException;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.StartInformationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class StartInformationMatching {
//    private StartInformationRepository startInformationRepository;
//    private Long startInformId;
//    private String name;
//    private BigDecimal power;
//    private BigInteger amount;
//
//    public StartInformationMatching(StartInformationRepository startInformationRepository, Long startInformId, String name, BigDecimal power, BigInteger amount) {
//        this.startInformationRepository = startInformationRepository;
//        this.startInformId = startInformId;
//        this.name = name;
//        this.power = power;
//        this.amount = amount;
//    }

    public static StartInformation createIfDontExist(StartInformationRepository startInformationRepository, Long startInformId,
                                                     String name, BigDecimal power, BigInteger amount, BigDecimal ki, BigDecimal cosf, BigDecimal tgf) {

        Optional<StartInformation> byId = startInformationRepository.findById(startInformId);
        if (byId.isPresent()) {
            throw new InformationAlreadyExistsException("Information about equipment with id № " + startInformId + " is already exists");
        }
        return new StartInformation(startInformId, name, power, amount, ki, cosf, tgf);
//        List<StartInformation> all = startInformationRepository.findAll();
//        all.stream().forEach(e->System.out.println(e.getName() + " " + name + " " + e.getName().equals(name)));
//        boolean isEmpty ;
//        isEmpty = all.stream().noneMatch(e ->
//                e.getName().equals(name) && e.getPower().equals(power) );
//        System.out.println("isEmpty = " + isEmpty);


//        if (isEmpty(all)) {
//            return new StartInformation(startInformId, name, power, amount);
//        } else {
//            throw new InformationAlreadyExistsException("Information about equipment with name: " + name + " and power: " + power + " is already exists");
//
//        }


    }

//    public Boolean isEmpty(List<StartInformation> all){
//        Boolean isEmpty = true;
//        for (StartInformation s:all) {
//            if (s.getName().equals(name) && s.getPower().equals(power)){
//                System.out.println("ищет совпадения" + isEmpty);
//                isEmpty = false;
//            }
//        }
//        System.out.println("isEmpty = " + isEmpty);
//        return isEmpty;
//    }
//
//    @Override
//    public String toString() {
//        return "StartInformationMatching{" +
//                "startInformationRepository=" + startInformationRepository +
//                ", startInformId=" + startInformId +
//                ", name='" + name + '\'' +
//                ", power=" + power +
//                ", amount=" + amount +
//                '}';
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        StartInformationMatching that = (StartInformationMatching) o;
//        return Objects.equals(startInformationRepository, that.startInformationRepository) && Objects.equals(startInformId, that.startInformId) && Objects.equals(name, that.name) && Objects.equals(power, that.power) && Objects.equals(amount, that.amount);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(startInformationRepository, startInformId, name, power, amount);
//    }
}
