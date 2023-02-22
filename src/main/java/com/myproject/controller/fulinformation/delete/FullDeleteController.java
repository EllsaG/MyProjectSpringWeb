package com.myproject.controller.fulinformation.delete;

import com.myproject.controller.dto.fullinformation.delete.FullDeleteRequestDTO;
import com.myproject.service.fullinformation.delete.FullDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullDeleteController {

    FullDeleteService fullDeleteService;

    @Autowired
    public FullDeleteController(FullDeleteService fullDeleteService) {
        this.fullDeleteService = fullDeleteService;
    }
    @DeleteMapping("/fullinformation/delete")
    public String deleteInfo(@RequestBody FullDeleteRequestDTO fullDeleteRequestDTO){
        return fullDeleteService.deleteInfo(fullDeleteRequestDTO.getDeleteId());
    }



}
