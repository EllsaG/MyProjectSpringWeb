package com.myproject.controller.dto.fullinformation.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myproject.entity.StartInformation;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

public class FullInformationRequestDTO {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nameOfBusbar")
    private String nameOfBusbar;

    @JsonProperty("amount")
    private Integer amount;



}
