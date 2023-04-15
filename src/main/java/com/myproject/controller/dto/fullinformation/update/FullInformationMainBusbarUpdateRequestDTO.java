package com.myproject.controller.dto.fullinformation.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
public class FullInformationMainBusbarUpdateRequestDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;
    @JsonProperty("numbersBusbarsIncludedInMain")
    private List<Long> numbersBusbarsIncludedInMain;

}
