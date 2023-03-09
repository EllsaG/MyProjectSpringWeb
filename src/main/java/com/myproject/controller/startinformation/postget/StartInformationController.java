package com.myproject.controller.startinformation.postget;

import com.myproject.controller.dto.startinformation.postget.StartInformationRequestDTO;
import com.myproject.controller.dto.startinformation.postget.StartInformationResponseDTO;
import com.myproject.controller.dto.startinformation.refresh.StartInformationRefreshResponseDTO;
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
    @GetMapping("/startinformation/all")
    public StartInformationRefreshResponseDTO getAllById(){
        StartInformationRefreshResponseDTO StartInformationRefreshResponseDTO = new StartInformationRefreshResponseDTO(startInformationService.getAllInformationById());
        return StartInformationRefreshResponseDTO;
    }

    @PostMapping("/startinformation/create")
    public StartInformationResponseDTO create(@RequestBody StartInformationRequestDTO startInformationRequestDTO) {
        startInformationService.save(startInformationRequestDTO.getStartInformId(),
                startInformationRequestDTO.getName(),startInformationRequestDTO.getPower(),
                startInformationRequestDTO.getAmount(), startInformationRequestDTO.getKi(),
                startInformationRequestDTO.getCosf(), startInformationRequestDTO.getTgf());
        StartInformationResponseDTO startInformationResponseDTO = new StartInformationResponseDTO(startInformationService
                .getAllInformationById());
        return startInformationResponseDTO;
    }


}
