package com.myproject.service.fullinformation.update;

import com.myproject.controller.dto.fullinformation.postget.FullInformationResponseDTO;
import com.myproject.entity.FullInformation;
import com.myproject.entity.FullStartInformId;
import com.myproject.service.fullinformation.postget.FullInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FullInformationUpdateService {

    FullInformationService fullInformationService;


    @Autowired
    public FullInformationUpdateService(FullInformationService fullInformationService) {
        this.fullInformationService = fullInformationService;

    }


    public FullInformationResponseDTO update(Long id, String nameOfBusbar,
                                             List<FullStartInformId> numbersAndAmountOfEquipments) {
        FullInformation informationById = fullInformationService.getInformationById(id);
        fullInformationService.delete(informationById);

        fullInformationService.update(id, nameOfBusbar, numbersAndAmountOfEquipments);
        return new FullInformationResponseDTO(fullInformationService.getAllFullInformation());
    }


}
