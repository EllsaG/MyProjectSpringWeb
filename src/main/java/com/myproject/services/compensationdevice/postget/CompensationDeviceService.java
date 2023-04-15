package com.myproject.services.compensationdevice.postget;

import com.myproject.controller.dto.compensatingdevice.postget.CompensationDeviceResponseDTO;
import com.myproject.entity.CompensationDevice;
import com.myproject.exceptions.InformationNotFoundException;
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


    public CompensationDeviceResponseDTO save(long id, String nameOfCompensationDevice, double powerOfCompensatingDevice) {

        ReactivePowerCompensation reactivePowerCompensation = new ReactivePowerCompensation();
        CompensationDevice newCompensatingDevice = reactivePowerCompensation.createNewCompensatingDevice(id, nameOfCompensationDevice, powerOfCompensatingDevice,
                fullInformationRepository, forChooseCompensationDeviceRepository);
        compensationDeviceRepository.save(newCompensatingDevice);
        return new CompensationDeviceResponseDTO(getAllInformation());

    }
    public CompensationDevice getInformationById(long id) {
        return compensationDeviceRepository.findById(id)
                .orElseThrow(()->new InformationNotFoundException("Unable to find information about compensation device with id № " + id));
    }
    public List<CompensationDevice> getAllInformation() {
        return compensationDeviceRepository.findAll();
    }


    public CompensationDeviceResponseDTO delete(CompensationDevice compensationDevice) {
        compensationDeviceRepository.delete(compensationDevice);
        return new CompensationDeviceResponseDTO(getAllInformation());
    }

    public CompensationDeviceResponseDTO update(long id, String nameOfCompensationDevice, double powerOfCompensatingDevice) {
        ReactivePowerCompensation reactivePowerCompensation = new ReactivePowerCompensation();
        CompensationDevice newCompensatingDevice = reactivePowerCompensation.createNewCompensatingDevice(id, nameOfCompensationDevice, powerOfCompensatingDevice,
                fullInformationRepository, forChooseCompensationDeviceRepository);
        compensationDeviceRepository.save(newCompensatingDevice);
        return new CompensationDeviceResponseDTO(getAllInformation());
    }

}
