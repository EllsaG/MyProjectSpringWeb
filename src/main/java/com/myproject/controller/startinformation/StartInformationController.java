package com.myproject.controller.startinformation;

import com.myproject.controller.dto.startinformation.StartInformationRequestDTO;
import com.myproject.controller.dto.startinformation.StartInformationResponseDTO;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.service.startinformation.StartInformationService;
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
    public String create(@RequestBody StartInformationRequestDTO startInformationRequestDTO) {
        return startInformationService.save(startInformationRequestDTO.getStartInformId(),
                startInformationRequestDTO.getName(),startInformationRequestDTO.getPower(),
                startInformationRequestDTO.getAmount());
    }


}
