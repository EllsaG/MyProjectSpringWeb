package com.myproject.service.fullstartinfromation;

import com.myproject.entity.FullStartInformId;
import com.myproject.exceptions.InformationNotFoundException;
import com.myproject.repositories.FullStartInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullStartInformationService {

    private final FullStartInformationRepository fullStartInformationRepository;

    @Autowired
    public FullStartInformationService(FullStartInformationRepository fullStartInformationRepository) {
        this.fullStartInformationRepository = fullStartInformationRepository;
    }

    public void save(FullStartInformId fullStartInformId) {
        fullStartInformationRepository.save(fullStartInformId);
    }





}
