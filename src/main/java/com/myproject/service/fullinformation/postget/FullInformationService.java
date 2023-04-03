package com.myproject.service.fullinformation.postget;


import com.myproject.controller.dto.fullinformation.postget.FullInformationResponseDTO;
import com.myproject.entity.FullInformation;
import com.myproject.entity.FullStartInformId;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.FullInformationRepository;
import com.myproject.service.startinformation.postget.StartInformationService;
import com.myproject.utils.ForFullTableLoadCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FullInformationService {

    private final FullInformationRepository fullInformationRepository;
    private final StartInformationService startInformationService;

    @Autowired
    public FullInformationService(FullInformationRepository fullInformationRepository, StartInformationService startInformationService) {
        this.fullInformationRepository = fullInformationRepository;
        this.startInformationService = startInformationService;
    }

    public FullInformationResponseDTO save(Long id, String nameOfBusbar,
                                           List<FullStartInformId> numbersAndAmountOfEquipments) {

        FullInformation fullInformation = ForFullTableLoadCalculation.calculation(fullInformationRepository,
                startInformationService, id, nameOfBusbar, numbersAndAmountOfEquipments);
        fullInformationRepository.save(fullInformation);
        return new FullInformationResponseDTO(getAllFullInformation());
    }
    public FullInformationResponseDTO saveMainBusbar(Long id, String nameOfBusbar,
                                           List<Long> numbersBusbarsIncludedInMain) {

        FullInformation fullInformation = ForFullTableLoadCalculation.calculationMainBusbar(fullInformationRepository,
                id, nameOfBusbar, numbersBusbarsIncludedInMain);
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

    public FullInformation update(Long id, String nameOfBusbar,
                                  List<FullStartInformId> numbersAndAmountOfEquipments) {
        FullInformation fullInformation = ForFullTableLoadCalculation.calculation(fullInformationRepository,
                startInformationService, id, nameOfBusbar, numbersAndAmountOfEquipments);
        return fullInformationRepository.save(fullInformation);
    }

    public void delete(FullInformation fullInformation) {
        fullInformationRepository.delete(fullInformation);
    }

    public void saveLighting(FullInformation fullInformation) {
        fullInformationRepository.save(fullInformation);
    }

}
