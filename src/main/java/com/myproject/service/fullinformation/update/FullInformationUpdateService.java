package com.myproject.service.fullinformation.update;

import com.myproject.entity.FullInformation;
import com.myproject.entity.FullStartInformId;
import com.myproject.service.fullinformation.postget.FullInformationService;
import com.myproject.service.fullstartinfromation.FullStartInformationService;
import com.myproject.utils.ForFullTableLoadCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FullInformationUpdateService {

    FullInformationService fullInformationService;
    FullStartInformationService fullStartInformationService;

    @Autowired
    public FullInformationUpdateService(FullInformationService fullInformationService,
                                        FullStartInformationService fullStartInformationService) {
        this.fullInformationService = fullInformationService;
        this.fullStartInformationService = fullStartInformationService;
    }


    public String update(Long id, String nameOfBusbar,
                         List<FullStartInformId> numbersAndAmountOfEquipments) {
        fullInformationService.deleteForUpdate(id);
        fullInformationService.save(id, nameOfBusbar, numbersAndAmountOfEquipments);
        return "Information about a busbar № " + id + " has been updated";
    }


}
