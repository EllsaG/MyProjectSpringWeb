package com.myproject.controller.fulinformation.update;

import com.myproject.controller.dto.fullinformation.postget.FullInformationRequestDTO;
import com.myproject.controller.dto.fullinformation.update.FullInformationUpdateRequestDTO;
import com.myproject.entity.FullStartInformId;
import com.myproject.service.fullinformation.update.FullInformationUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
public class FullUpdateController {

    FullInformationUpdateService fullInformationUpdateService;

    @Autowired
    public FullUpdateController(FullInformationUpdateService fullInformationUpdateService) {
        this.fullInformationUpdateService = fullInformationUpdateService;
    }

    @PatchMapping("/fullinformation/update")
    public String updateInfo(@RequestBody FullInformationUpdateRequestDTO fullInformationUpdateRequestDTO) {
        fullInformationUpdateService.update(fullInformationUpdateRequestDTO.getId(),
                fullInformationUpdateRequestDTO.getNameOfBusbar(),
                fullInformationUpdateRequestDTO.getFullStartInformIdRequestDTO().stream()
                        .map(e -> new FullStartInformId(e.getNumberOfBusbar(), e.getNumberOfEquipment(), e.getAmountOfEquipment()))
                        .collect(Collectors.toList()));
        return "information updated";
    }


}
