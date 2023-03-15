package com.myproject.controller.dto.fullinformation.refresh;

import com.myproject.entity.FullInformation;
import com.myproject.entity.StartInformation;

import java.util.List;

public class FullInformationRefreshResponseDTO {

    private List<FullInformation> list;

    public FullInformationRefreshResponseDTO(List<FullInformation> list) {
        this.list = list;
    }

    public List<FullInformation> getList() {
        return list;
    }

    public void setList(List<FullInformation> list) {
        this.list = list;
    }
}
