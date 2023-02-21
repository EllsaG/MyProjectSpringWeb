package com.myproject.service.fullinformation.update;

import com.myproject.entity.FullInformation;
import com.myproject.entity.FullStartInformId;
import com.myproject.service.fullinformation.postget.FullInformationService;
import com.myproject.utils.ForFullTableLoadCalculation;
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


    public String update(Long id, String nameOfBusbar,
                         List<FullStartInformId> numbersAndAmountOfEquipments) {
        FullInformation informationById = fullInformationService.getInformationById(id);
        fullInformationService.delete(informationById);

        fullInformationService.update(id, nameOfBusbar, numbersAndAmountOfEquipments);
        return "Information about a busbar № " + id + " has been updated";
    }


}
