package com.myproject.service.fullinformation.postget;

import com.myproject.repositories.FullInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class FullInformationService {

    private final FullInformationRepository fullInformationRepository;

    @Autowired
    public FullInformationService(FullInformationRepository fullInformationRepository) {
        this.fullInformationRepository = fullInformationRepository;
    }

    public String save (Integer id, String nameOfBusbar,
                        HashMap<Integer, Integer> numbersAndAmountOfEquipments){




    }



}
