package com.myproject.controller.dto.startinformation.refresh;

import com.myproject.entity.StartInformation;

import java.util.List;

public class StartInformationRefreshResponseDTO {

    private List<StartInformation> list;

    public StartInformationRefreshResponseDTO(List<StartInformation> list) {
        this.list = list;
    }

    public List<StartInformation> getList() {
        return list;
    }

    public void setList(List<StartInformation> list) {
        this.list = list;
    }
}
