package com.myproject.service.compensationdevice.delete;

import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceResponseDTO;
import com.myproject.entity.CompensationDevice;
import com.myproject.service.compensationdevice.postget.CompensationDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationDeviceDeleteService {

    private final CompensationDeviceService compensationDeviceService;


@Autowired
    public CompensationDeviceDeleteService(CompensationDeviceService compensationDeviceService) {
        this.compensationDeviceService = compensationDeviceService;
    }

    public CompensationDeviceResponseDTO delete(long idForDelete){
        CompensationDevice informationById = compensationDeviceService.getInformationById(idForDelete);
        return compensationDeviceService.delete(informationById);
    }

}
