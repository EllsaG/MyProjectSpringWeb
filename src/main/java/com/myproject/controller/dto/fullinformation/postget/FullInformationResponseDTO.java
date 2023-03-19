package com.myproject.controller.dto.fullinformation.postget;

import com.myproject.entity.FullInformation;

import java.util.List;

public class FullInformationResponseDTO {

    private List<FullInformation> list;

    public FullInformationResponseDTO(List<FullInformation> list) {
        this.list = list;
    }

    public List<FullInformation> getList() {
        return list;
    }

    public void setList(List<FullInformation> list) {
        this.list = list;
    }
}
