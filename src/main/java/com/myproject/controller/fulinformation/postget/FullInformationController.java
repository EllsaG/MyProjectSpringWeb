package com.myproject.controller.fulinformation.postget;

import com.myproject.controller.dto.fullinformation.postget.FullInformationRequestDTO;
import com.myproject.controller.dto.pojo.NumbersAndAmountOfEquipments;
import com.myproject.service.fullinformation.postget.FullInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class FullInformationController {

    FullInformationService fullInformationService;

    @Autowired
    public FullInformationController(FullInformationService fullInformationService) {
        this.fullInformationService = fullInformationService;
    }

    @PostMapping("/fullinformation/create")
    public String create(@RequestBody FullInformationRequestDTO fullInformationRequestDTO) {
        return fullInformationService.save(fullInformationRequestDTO.getId(),
                fullInformationRequestDTO.getNameOfBusbar(),
                    fullInformationRequestDTO.getNumbersAndAmountOfEquipments().stream()
                            .map(e -> new NumbersAndAmountOfEquipments(e.getNumbersOfEquipment(),e.getAmountOfEquipments()))
                            .collect(Collectors.toList())) ;
    }


}
