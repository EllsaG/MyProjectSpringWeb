package com.myproject.controller.dto.fullinformation.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FullInformationMainBusbarUpdateRequestDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;
    @JsonProperty("numbersBusbarsIncludedInMain")
    private List<Long> numbersBusbarsIncludedInMain;

    public Long getId() {
        return id;
    }

    public String getNameOfBusbar() {
        return nameOfBusbar;
    }

    public List<Long> getNumbersBusbarsIncludedInMain() {
        return numbersBusbarsIncludedInMain;
    }
}
