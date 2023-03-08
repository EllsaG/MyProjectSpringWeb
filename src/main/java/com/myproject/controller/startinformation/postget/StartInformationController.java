package com.myproject.controller.startinformation.postget;

import com.myproject.controller.dto.startinformation.postget.StartInformationRequestDTO;
import com.myproject.controller.dto.startinformation.postget.StartInformationResponseDTO;
import com.myproject.entity.StartInformation;
import com.myproject.service.startinformation.postget.StartInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StartInformationController {

    private final StartInformationService startInformationService;

    @Autowired
    public StartInformationController(StartInformationService startInformationService) {
        this.startInformationService = startInformationService;
    }

    @GetMapping("/startinformation/{startInformId}")
    public StartInformationResponseDTO getById(@PathVariable Long startInformId){
        return new StartInformationResponseDTO(startInformationService.getInformationById(startInformId));
    }

    @PostMapping("/startinformation/create")
    public StartInformationResponseDTO create(@RequestBody StartInformationRequestDTO startInformationRequestDTO) {
        Long startInformId = startInformationRequestDTO.getStartInformId();
        startInformationService.save(startInformationRequestDTO.getStartInformId(),
                startInformationRequestDTO.getName(),startInformationRequestDTO.getPower(),
                startInformationRequestDTO.getAmount(), startInformationRequestDTO.getKi(),
                startInformationRequestDTO.getCosf(), startInformationRequestDTO.getTgf());
        StartInformationResponseDTO startInformationResponseDTO = new StartInformationResponseDTO(startInformationService
                .getInformationById(startInformId));
        return startInformationResponseDTO;
    }


}
