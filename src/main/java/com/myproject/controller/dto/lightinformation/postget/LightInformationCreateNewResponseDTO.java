package com.myproject.controller.dto.lightinformation.postget;

import com.myproject.entity.LightInformation;

import java.util.List;

public class LightInformationCreateNewResponseDTO {

    List<LightInformation> list;

    public LightInformationCreateNewResponseDTO(List<LightInformation> list) {
        this.list = list;
    }

    public List<LightInformation> getList() {
        return list;
    }

    public void setList(List<LightInformation> list) {
        this.list = list;
    }


}
