package com.myproject.service.fullinformation.postget;

import com.myproject.repositories.FullInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FullInformationService {

    FullInformationRepository fullInformationRepository;

    @Autowired
    public FullInformationService(FullInformationRepository fullInformationRepository) {
        this.fullInformationRepository = fullInformationRepository;
    }

    public String save



}
