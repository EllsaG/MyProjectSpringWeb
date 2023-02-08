package com.myproject.controller;

import com.myproject.controller.dto.StartInformationRequestDTO;
import com.myproject.controller.dto.StartInformationResponseDTO;
import com.myproject.service.StartInformationService;
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
    public StartInformationResponseDTO getById(@PathVariable Long startInformId) {
        return new StartInformationResponseDTO(startInformationService.getInformationById(startInformId));
    }
@PostMapping("/startinformation")
    public String create(@RequestBody StartInformationRequestDTO startInformationRequestDTO) {
        return startInformationService.save(startInformationRequestDTO.getName(),
                startInformationRequestDTO.getPower(), startInformationRequestDTO.getAmount());
    }

}
