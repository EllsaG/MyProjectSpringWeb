package com.myproject.controller.startinformation.update;


import com.myproject.controller.dto.startinformation.postget.StartInformationRequestDTO;
import com.myproject.service.update.StartInformationUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateController {

    private final StartInformationUpdateService startInformationUpdateService;

    @Autowired
    public UpdateController(StartInformationUpdateService startInformationUpdateService) {
        this.startInformationUpdateService = startInformationUpdateService;
    }

    @PatchMapping("/startinformation/update")
    public String updateInfo(@RequestBody StartInformationRequestDTO startInformationRequestDTO){
        return startInformationUpdateService.update(startInformationRequestDTO.getStartInformId()
                ,startInformationRequestDTO.getName(),startInformationRequestDTO.getPower()
                ,startInformationRequestDTO.getAmount());
    }



}
