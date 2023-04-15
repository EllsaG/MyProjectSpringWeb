package com.myproject.controller.compensatingdevice.delete;

import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceResponseDTO;
import com.myproject.services.compensationdevice.delete.CompensationDeviceDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompensationDeviceDeleteController {

private final CompensationDeviceDeleteService compensationDeviceDeleteService;

@Autowired
    public CompensationDeviceDeleteController(CompensationDeviceDeleteService compensationDeviceDeleteService) {
        this.compensationDeviceDeleteService = compensationDeviceDeleteService;
    }
    @DeleteMapping("/compensationdevice/delete/{idForDelete}")
    public CompensationDeviceResponseDTO deleteInfo(@PathVariable long idForDelete){
        return compensationDeviceDeleteService.delete(idForDelete);
    }

}
