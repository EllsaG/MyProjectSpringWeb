package com.myproject.controller.startinformation.delete;


import com.myproject.controller.dto.startinformation.postget.StartInformationRequestDTO;
import com.myproject.controller.dto.startinformation.refresh.StartInformationRefreshResponseDTO;
import com.myproject.service.startinformation.delete.StartInformationDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    private final StartInformationDeleteService startInformationDeleteService;

    @Autowired
    public DeleteController(StartInformationDeleteService startInformationDeleteService) {
        this.startInformationDeleteService = startInformationDeleteService;
    }
    @DeleteMapping("/startinformation/delete/{idForDelete}")
    public StartInformationRefreshResponseDTO deleteInfo(@PathVariable Long idForDelete){
        return startInformationDeleteService.delete(idForDelete);
    }

}
