package com.myproject.services.fullinformation.update;

import com.myproject.controller.dto.fullinformation.postget.FullInformationResponseDTO;
import com.myproject.entity.FullInformation;
import com.myproject.entity.FullStartInformId;
import com.myproject.services.fullinformation.postget.FullInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FullInformationUpdateService {

    private final FullInformationService fullInformationService;


    @Autowired
    public FullInformationUpdateService(FullInformationService fullInformationService) {
        this.fullInformationService = fullInformationService;

    }


    public FullInformationResponseDTO update(long id, String nameOfBusbar,
                                             List<FullStartInformId> numbersAndAmountOfEquipments) {
        FullInformation informationById = fullInformationService.getInformationById(id);
        fullInformationService.delete(informationById);

        fullInformationService.update(id, nameOfBusbar, numbersAndAmountOfEquipments);
        return new FullInformationResponseDTO(fullInformationService.getAllFullInformation());
    }

    public FullInformationResponseDTO updateMainBusbar(long id, String nameOfBusbar,
                                                       List<Long> numbersBusbarsIncludedInMain) {
        FullInformation informationById = fullInformationService.getInformationById(id);
        fullInformationService.delete(informationById);

        return fullInformationService.updateMainBusbar(id, nameOfBusbar, numbersBusbarsIncludedInMain);
    }

}
