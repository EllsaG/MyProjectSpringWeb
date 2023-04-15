package com.myproject.controller.dto.startinformation.postget;

import com.myproject.entity.StartInformation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class StartInformationResponseDTO {

    private List<StartInformation> list;

    public StartInformationResponseDTO(List<StartInformation> list) {
        this.list = list;
    }
}
