package com.myproject.controller.update;


import com.myproject.controller.dto.StartInformationRequestDTO;
import com.myproject.service.startinformation.StartInformationService;
import com.myproject.service.update.StartInformationUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    StartInformationService startInformationService;

    @Autowired
    public UpdateController(StartInformationService startInformationService) {
        this.startInformationService = startInformationService;
    }

    @PatchMapping("/startinformation/{startInformId}")
    public String update(@RequestBody StartInformationRequestDTO startInformationRequestDTO,
                         @PathVariable("startInformId") String startInformId){
        return startInformationService.save(startInformationRequestDTO.getName(),
                startInformationRequestDTO.getPower(), startInformationRequestDTO.getAmount());
    }



}
