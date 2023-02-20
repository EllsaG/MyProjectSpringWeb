package com.myproject.service.fullinformation.postget;


import com.myproject.entity.FullInformation;
import com.myproject.entity.FullStartInformId;
import com.myproject.exceptions.InformationAlreadyExistsException;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.FullInformationRepository;
import com.myproject.service.fullstartinfromation.FullStartInformationService;
import com.myproject.service.startinformation.postget.StartInformationService;
import com.myproject.utils.ForFullTableLoadCalculation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class FullInformationService {

    private final FullInformationRepository fullInformationRepository;
    private final StartInformationService startInformationService;
    private final FullStartInformationService fullStartInformationService;

    @Autowired
    public FullInformationService(FullInformationRepository fullInformationRepository, StartInformationService startInformationService, FullStartInformationService fullStartInformationService) {
        this.fullInformationRepository = fullInformationRepository;
        this.startInformationService = startInformationService;
        this.fullStartInformationService = fullStartInformationService;
    }

    public String save(Long id, String nameOfBusbar,
                       List<FullStartInformId> numbersAndAmountOfEquipments) {

        FullInformation fullInformation = ForFullTableLoadCalculation.calculation(fullInformationRepository,
                startInformationService, id, nameOfBusbar, numbersAndAmountOfEquipments);
        numbersAndAmountOfEquipments.stream()
                .forEach(e -> fullStartInformationService.save(new FullStartInformId(e.getFullInformationId(),
                        e.getStartInformId(), e.getAmount())));

        fullInformationRepository.save(fullInformation);
        return "Information about new busbar is saved ";

    }

    public FullInformation getInformationById(Long fullInformationId) {
        return fullInformationRepository.findById(fullInformationId)
                .orElseThrow(() -> new InformationNotFoundException("Unable to find information about busbar with id № " + fullInformationId));
    }

    public FullInformation update(FullInformation fullInformation) {
        return fullInformationRepository.save(fullInformation);
    }

    public void delete(FullInformation fullInformation) {
        fullInformationRepository.delete(fullInformation);
    }


    public void deleteForUpdate(Long fullInformationIdn) {
        fullInformationRepository.deleteById(fullInformationIdn);
    }

}
