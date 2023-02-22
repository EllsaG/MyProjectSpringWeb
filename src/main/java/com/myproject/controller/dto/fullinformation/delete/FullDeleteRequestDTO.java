package com.myproject.controller.dto.fullinformation.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FullDeleteRequestDTO {

    @JsonProperty("deleteId")
    private Long deleteId;

    public Long getDeleteId() {
        return deleteId;
    }
}
