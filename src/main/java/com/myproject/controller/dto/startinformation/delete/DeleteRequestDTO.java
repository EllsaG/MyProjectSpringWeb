package com.myproject.controller.dto.startinformation.delete;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.math.BigInteger;

public class DeleteRequestDTO { // choose to delete by number in the body of the request. maybe i'll change it later.
    @JsonProperty("startInformId")
    private Long startInformId;

    public Long getStartInformId() {
        return startInformId;
    }
}
