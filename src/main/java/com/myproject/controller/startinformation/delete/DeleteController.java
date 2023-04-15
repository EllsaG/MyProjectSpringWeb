package com.myproject.controller.startinformation.delete;


import com.myproject.controller.dto.startinformation.postget.StartInformationResponseDTO;
import com.myproject.services.startinformation.delete.StartInformationDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    private final StartInformationDeleteService startInformationDeleteService;

    @Autowired
    public DeleteController(StartInformationDeleteService startInformationDeleteService) {
        this.startInformationDeleteService = startInformationDeleteService;
    }
    @DeleteMapping("/startinformation/delete/{idForDelete}")
    public StartInformationResponseDTO deleteInfo(@PathVariable long idForDelete){
        return startInformationDeleteService.delete(idForDelete);
    }

}
