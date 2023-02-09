package com.myproject.service.update;

import com.myproject.controller.dto.StartInformationRequestDTO;
import com.myproject.entity.StartInformation;
import com.myproject.service.startinformation.StartInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class StartInformationUpdateService {

    StartInformationService startInformationService;

    @Autowired
    public StartInformationUpdateService(StartInformationService startInformationService) {
        this.startInformationService = startInformationService;
    }

    public Object update(StartInformation startInformation) {
        return startInformationService.save(startInformation);
    }

/




}
