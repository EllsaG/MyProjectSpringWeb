package com.myproject.controller.compensatingdevice.update;

import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceResponseDTO;
import com.myproject.controller.dto.compensatingdevice.update.CompensationDeviceUpdateRequestDTO;
import com.myproject.service.compensationdevice.update.CompensationDeviceUpdateService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompensationDeviceUpdateController {

    private final CompensationDeviceUpdateService compensationDeviceUpdateService;


    public CompensationDeviceUpdateController(CompensationDeviceUpdateService compensationDeviceUpdateService) {
        this.compensationDeviceUpdateService = compensationDeviceUpdateService;
    }
    @PostMapping("/compensationdevice/update")
    public CompensationDeviceResponseDTO update(@RequestBody CompensationDeviceUpdateRequestDTO compensationDeviceUpdateRequestDTO){
        return compensationDeviceUpdateService.update(compensationDeviceUpdateRequestDTO.getId(),
                compensationDeviceUpdateRequestDTO.getNameOfCompensationDevice(),
                compensationDeviceUpdateRequestDTO.getPowerOfCompensatingDevice());
    }




}
