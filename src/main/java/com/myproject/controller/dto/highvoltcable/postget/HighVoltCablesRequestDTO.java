package com.myproject.controller.dto.highvoltcable.postget;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class HighVoltCablesRequestDTO {

    @JsonProperty("id")
    private long id;
    @JsonProperty("baseVoltage")
    private int baseVoltage;
    @JsonProperty("baseFullPower")
    private int baseFullPower;
    @JsonProperty("relativeBaselineUnrestrictedPowerResistance")
    private double relativeBaselineUnrestrictedPowerResistance;
    @JsonProperty("highVoltageAirLineLength")
    private double highVoltageAirLineLength;
    @JsonProperty("headTransformerFullPower")
    private double headTransformerFullPower;
    @JsonProperty("shortCircuitVoltage")
    private double shortCircuitVoltage;
    @JsonProperty("cableLineLength")
    private double cableLineLength;
    @JsonProperty("ratedVoltageOfHigherVoltageWindingOfTransformer")
    private double ratedVoltageOfHigherVoltageWindingOfTransformer;
    @JsonProperty("inductiveResistanceAreasList")
    private List<InductiveResistanceAreasRequestDTO> inductiveResistanceAreasList;
}
