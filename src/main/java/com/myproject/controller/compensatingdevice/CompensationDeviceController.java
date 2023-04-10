package com.myproject.controller.compensatingdevice;

import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceRequestDTO;
import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceResponseDTO;
import com.myproject.service.compensationdevice.CompensationDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompensationDeviceController {

    private final CompensationDeviceService compensationDeviceService;

    @Autowired
    public CompensationDeviceController(CompensationDeviceService compensationDeviceService) {
        this.compensationDeviceService = compensationDeviceService;
    }


    @PostMapping("/compensationdevice/create")
    public CompensationDeviceResponseDTO save(@RequestBody CompensationDeviceRequestDTO compensationDeviceRequestDTO) {
        return compensationDeviceService.save(compensationDeviceRequestDTO.getId(),compensationDeviceRequestDTO.getNameOfCompensationDevice(),
                compensationDeviceRequestDTO.getPowerOfCompensatingDevice());
    }


}
