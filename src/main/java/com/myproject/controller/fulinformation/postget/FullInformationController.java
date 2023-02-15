package com.myproject.controller.fulinformation.postget;

import com.myproject.service.fullinformation.postget.FullInformationService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FullInformationController {

    FullInformationService fullInformationService;

    public FullInformationController(FullInformationService fullInformationService) {
        this.fullInformationService = fullInformationService;
    }



}
