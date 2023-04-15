package com.myproject.controller.compensatingdevice.postget;

import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceRequestDTO;
import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceResponseDTO;
import com.myproject.services.compensationdevice.postget.CompensationDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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


    @GetMapping("/compensationdevice/all")
    public CompensationDeviceResponseDTO getAll(){
        return new CompensationDeviceResponseDTO(compensationDeviceService.getAllInformation());
    }

    @PostMapping("/compensationdevice/create")
    public CompensationDeviceResponseDTO save(@RequestBody CompensationDeviceRequestDTO compensationDeviceRequestDTO) {
        return compensationDeviceService.save(compensationDeviceRequestDTO.getId(),compensationDeviceRequestDTO.getNameOfCompensationDevice(),
                compensationDeviceRequestDTO.getPowerOfCompensatingDevice());
    }


}
