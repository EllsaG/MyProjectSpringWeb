package com.myproject.service.compensationdevice;

import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceResponseDTO;
import com.myproject.entity.CompensationDevice;
import com.myproject.repositories.CompensationDeviceRepository;
import com.myproject.repositories.ForChooseCompensationDeviceRepository;
import com.myproject.repositories.FullInformationRepository;
import com.myproject.utils.ReactivePowerCompensation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompensationDeviceService {

    private final FullInformationRepository fullInformationRepository;
    private final CompensationDeviceRepository compensationDeviceRepository;
    private final ForChooseCompensationDeviceRepository forChooseCompensationDeviceRepository;
    @Autowired

    public CompensationDeviceService(FullInformationRepository fullInformationRepository, CompensationDeviceRepository compensationDeviceRepository, ForChooseCompensationDeviceRepository forChooseCompensationDeviceRepository) {
        this.fullInformationRepository = fullInformationRepository;
        this.compensationDeviceRepository = compensationDeviceRepository;
        this.forChooseCompensationDeviceRepository = forChooseCompensationDeviceRepository;
    }



    public CompensationDeviceResponseDTO save (long id, String nameOfCompensationDevice, double powerOfCompensatingDevice){

        ReactivePowerCompensation reactivePowerCompensation = new ReactivePowerCompensation();
        CompensationDevice newCompensatingDevice = reactivePowerCompensation.createNewCompensatingDevice(id, nameOfCompensationDevice, powerOfCompensatingDevice,
                fullInformationRepository, forChooseCompensationDeviceRepository);
        compensationDeviceRepository.save(newCompensatingDevice);
        return new CompensationDeviceResponseDTO(getAllInformation());

    }

    public List<CompensationDevice> getAllInformation(){
        return compensationDeviceRepository.findAll();
    }




}
