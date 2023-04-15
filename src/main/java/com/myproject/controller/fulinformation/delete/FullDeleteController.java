package com.myproject.controller.fulinformation.delete;

import com.myproject.controller.dto.fullinformation.postget.FullInformationResponseDTO;
import com.myproject.services.fullinformation.delete.FullDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullDeleteController {

    FullDeleteService fullDeleteService;

    @Autowired
    public FullDeleteController(FullDeleteService fullDeleteService) {
        this.fullDeleteService = fullDeleteService;
    }
    @DeleteMapping("/fullinformation/delete/{idForDelete}")
    public FullInformationResponseDTO deleteInfo(@PathVariable  long idForDelete){
        return fullDeleteService.deleteInfoById(idForDelete);
    }



}
