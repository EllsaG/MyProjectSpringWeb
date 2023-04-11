package com.myproject.service.compensationdevice.update;

import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceResponseDTO;
import com.myproject.entity.CompensationDevice;
import com.myproject.service.compensationdevice.postget.CompensationDeviceService;
import org.springframework.stereotype.Service;

@Service
public class CompensationDeviceUpdateService {

    private final CompensationDeviceService compensationDeviceService;

    public CompensationDeviceUpdateService(CompensationDeviceService compensationDeviceService) {
        this.compensationDeviceService = compensationDeviceService;
    }

    public CompensationDeviceResponseDTO update(long id, String nameOfCompensationDevice, double powerOfCompensatingDevice) {
        CompensationDevice informationById = compensationDeviceService.getInformationById(id);
        compensationDeviceService.delete(informationById);
        return compensationDeviceService.update(id, nameOfCompensationDevice, powerOfCompensatingDevice);
    }


}
