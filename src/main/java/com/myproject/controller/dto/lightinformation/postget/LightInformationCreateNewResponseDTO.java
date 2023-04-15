package com.myproject.controller.dto.lightinformation.postget;

import com.myproject.entity.LightInformation;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class LightInformationCreateNewResponseDTO {

    List<LightInformation> list;
    public LightInformationCreateNewResponseDTO(List<LightInformation> list) {
        this.list = list;
    }

}
