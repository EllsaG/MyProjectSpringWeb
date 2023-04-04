package com.myproject.controller.dto.fullinformation.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FullDeleteRequestDTO {

    @JsonProperty("deleteId")
    private long deleteId;

    public long getDeleteId() {
        return deleteId;
    }
}
