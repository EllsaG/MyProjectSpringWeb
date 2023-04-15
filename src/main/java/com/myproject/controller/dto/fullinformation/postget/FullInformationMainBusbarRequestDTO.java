package com.myproject.controller.dto.fullinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
public class FullInformationMainBusbarRequestDTO {
    @JsonProperty("id")
    private long id;
    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;
    @JsonProperty("numbersBusbarsIncludedInMain")
    private List<Long> numbersBusbarsIncludedInMain;

}
