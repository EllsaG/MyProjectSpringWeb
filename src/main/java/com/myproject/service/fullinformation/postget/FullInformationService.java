package com.myproject.service.fullinformation.postget;


import com.myproject.controller.dto.fullinformation.postget.FullInformationResponseDTO;
import com.myproject.entity.ForChooseCompensationDevice;
import com.myproject.entity.FullInformation;
import com.myproject.entity.FullStartInformId;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.ForChooseCompensationDeviceRepository;
import com.myproject.repositories.ForChooseLuminaireRepository;
import com.myproject.repositories.FullInformationRepository;
import com.myproject.service.startinformation.postget.StartInformationService;
import com.myproject.utils.ForFullTableLoadCalculation;
import com.myproject.utils.ReactivePowerCompensation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FullInformationService {

    private final FullInformationRepository fullInformationRepository;
    private final StartInformationService startInformationService;
    private final ForChooseCompensationDeviceRepository forChooseCompensationDeviceRepository;
    @Autowired

    public FullInformationService(FullInformationRepository fullInformationRepository, StartInformationService startInformationService,
                                  ForChooseCompensationDeviceRepository forChooseCompensationDeviceRepository) {
        this.fullInformationRepository = fullInformationRepository;
        this.startInformationService = startInformationService;
        this.forChooseCompensationDeviceRepository = forChooseCompensationDeviceRepository;
    }



    public FullInformationResponseDTO save(long id, String nameOfBusbar,
                                           List<FullStartInformId> numbersAndAmountOfEquipments) {
        ForFullTableLoadCalculation forFullTableLoadCalculation = new ForFullTableLoadCalculation();
        FullInformation fullInformation = forFullTableLoadCalculation.calculation(fullInformationRepository,
                startInformationService, id, nameOfBusbar, numbersAndAmountOfEquipments);
        fullInformationRepository.save(fullInformation);
        return new FullInformationResponseDTO(getAllFullInformation());
    }

    public FullInformationResponseDTO saveMainBusbar(long id, String nameOfBusbar,
                                                     List<Long> numbersBusbarsIncludedInMain) {
        ForFullTableLoadCalculation forFullTableLoadCalculation = new ForFullTableLoadCalculation();
        FullInformation fullInformation = forFullTableLoadCalculation.calculationMainBusbar(fullInformationRepository,
                id, nameOfBusbar, numbersBusbarsIncludedInMain);

        ReactivePowerCompensation reactivePowerCompensation = new ReactivePowerCompensation();
        ForChooseCompensationDevice forChooseCompensationDevice = reactivePowerCompensation.powerOfCompensatingDevice(
                id, fullInformation.getAvgDailyActivePower(), fullInformation.getTgF());

        forChooseCompensationDeviceRepository.save(forChooseCompensationDevice);
        fullInformationRepository.save(fullInformation);

        return new FullInformationResponseDTO(getAllFullInformation());
    }

    public FullInformation getInformationById(Long fullInformationId) {
        return fullInformationRepository.findById(fullInformationId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about busbar with id № " + fullInformationId));
    }

    public List<FullInformation> getAllFullInformation() {
        return fullInformationRepository.findAll();
    }

    public void update(long id, String nameOfBusbar,
                       List<FullStartInformId> numbersAndAmountOfEquipments) {
        ForFullTableLoadCalculation forFullTableLoadCalculation = new ForFullTableLoadCalculation();
        FullInformation fullInformation = forFullTableLoadCalculation.calculation(fullInformationRepository,
                startInformationService, id, nameOfBusbar, numbersAndAmountOfEquipments);
        fullInformationRepository.save(fullInformation);
    }

    public FullInformationResponseDTO updateMainBusbar(long id, String nameOfBusbar,
                                 List<Long> numbersBusbarsIncludedInMain) {
        saveMainBusbar(id,nameOfBusbar, numbersBusbarsIncludedInMain);
        return new FullInformationResponseDTO(getAllFullInformation());
    }

    public void delete(FullInformation fullInformation) {
        long idForDeleteCompensationDevice = fullInformation.getId();
        fullInformationRepository.delete(fullInformation);
        if (forChooseCompensationDeviceRepository.findById(idForDeleteCompensationDevice).isPresent()){
            forChooseCompensationDeviceRepository.deleteById(idForDeleteCompensationDevice);
        }
    }

}
