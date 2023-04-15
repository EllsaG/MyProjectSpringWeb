package com.myproject.controller.dto.fullinformation.postget;

import com.myproject.entity.FullInformation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class FullInformationResponseDTO {

    private List<FullInformation> list;

    public FullInformationResponseDTO(List<FullInformation> list) {
        this.list = list;
    }
}
