package com.myproject.controller.startinformation.delete;

import com.myproject.controller.dto.startinformation.postget.StartInformationRequestDTO;
import com.myproject.service.startinformation.delete.StartInformationDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    private final StartInformationDeleteService startInformationDeleteService;

    @Autowired
    public DeleteController(StartInformationDeleteService startInformationDeleteService) {
        this.startInformationDeleteService = startInformationDeleteService;
    }
    @DeleteMapping("/startinformation/delete")
    public String deleteInfo(@RequestBody StartInformationRequestDTO startInformationRequestDTO){
        return startInformationDeleteService.delete(startInformationRequestDTO.getStartInformId());
    }

}
