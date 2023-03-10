package com.myproject.controller.fulinformation.postget;

import com.myproject.controller.dto.fullinformation.postget.FullInformationRequestDTO;
import com.myproject.controller.dto.fullinformation.postget.FullInformationResponseDTO;
import com.myproject.entity.FullStartInformId;
import com.myproject.service.fullinformation.postget.FullInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class FullInformationController {

    private final FullInformationService fullInformationService;

    @Autowired
    public FullInformationController(FullInformationService fullInformationService) {
        this.fullInformationService = fullInformationService;
    }

    @GetMapping("/fullinformation/{fullInformationId}")
    public FullInformationResponseDTO getById(@PathVariable Long fullInformationId) {
        return new FullInformationResponseDTO(fullInformationService.getInformationById(fullInformationId));
    }

    @PostMapping("/fullinformation/create")
    public String create(@RequestBody FullInformationRequestDTO fullInformationRequestDTO) {
        return fullInformationService.save(fullInformationRequestDTO.getId(),
                fullInformationRequestDTO.getNameOfBusbar(),
                fullInformationRequestDTO.getFullStartInformIdRequestDTO().stream()
                        .map(e -> new FullStartInformId(e.getNumberOfBusbar(), e.getNumberOfEquipment(), e.getAmountOfEquipment()))
                        .collect(Collectors.toList()));
    }


}
