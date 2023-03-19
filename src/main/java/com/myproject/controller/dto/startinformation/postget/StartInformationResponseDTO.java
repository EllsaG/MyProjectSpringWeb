package com.myproject.controller.dto.startinformation.postget;

import com.myproject.entity.StartInformation;

import java.util.List;

public class StartInformationResponseDTO {

    private List<StartInformation> list;

    public StartInformationResponseDTO(List<StartInformation> list) {
        this.list = list;
    }

    public List<StartInformation> getList() {
        return list;
    }

    public void setList(List<StartInformation> list) {
        this.list = list;
    }
}
