package com.myproject.services.compensationdevice.update;

import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceResponseDTO;
import com.myproject.entity.CompensationDevice;
import com.myproject.services.compensationdevice.postget.CompensationDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompensationDeviceUpdateService {

    private final CompensationDeviceService compensationDeviceService;
@Autowired
    public CompensationDeviceUpdateService(CompensationDeviceService compensationDeviceService) {
        this.compensationDeviceService = compensationDeviceService;
    }

    public CompensationDeviceResponseDTO update(long id, String nameOfCompensationDevice, double powerOfCompensatingDevice) {
        CompensationDevice informationById = compensationDeviceService.getInformationById(id);
        compensationDeviceService.delete(informationById);
        return compensationDeviceService.update(id, nameOfCompensationDevice, powerOfCompensatingDevice);
    }


}
