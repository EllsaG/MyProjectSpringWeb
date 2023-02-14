package com.myproject.controller.dto.startinformation.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DeleteRequestDTO {
    @JsonProperty("startInformId")
    private Long startInformId;

    public Long getStartInformId() {
        return startInformId;
    }
}
