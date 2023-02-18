package com.myproject.service.fullinformation.postget;

import com.myproject.controller.dto.fullinformation.postget.NumbersAndAmountOfEquipmentsRequestDTO;
import com.myproject.controller.dto.pojo.NumbersAndAmountOfEquipments;
import com.myproject.entity.FullInformation;
import com.myproject.repositories.FullInformationRepository;
import com.myproject.service.startinformation.postget.StartInformationService;
import com.myproject.utils.ForFullTableLoadCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class FullInformationService {

    private final FullInformationRepository fullInformationRepository;
    private final StartInformationService startInformationService;

    @Autowired
    public FullInformationService(FullInformationRepository fullInformationRepository, StartInformationService startInformationService) {
        this.fullInformationRepository = fullInformationRepository;
        this.startInformationService = startInformationService;
    }

    public String save (Long id, String nameOfBusbar,
                        List<NumbersAndAmountOfEquipments> numbersAndAmountOfEquipments){

        FullInformation fullInformation =  ForFullTableLoadCalculation.calculation(startInformationService,  id,
                         nameOfBusbar,  numbersAndAmountOfEquipments);
        fullInformationRepository.save(fullInformation);
        return "Information about new busbar is saved ";

    }



}
