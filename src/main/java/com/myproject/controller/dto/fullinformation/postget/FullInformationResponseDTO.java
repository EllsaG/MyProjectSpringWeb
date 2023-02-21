package com.myproject.controller.dto.fullinformation.postget;

import com.myproject.entity.FullInformation;
import java.util.List;
import java.util.stream.Collectors;

public class FullInformationResponseDTO {
    private Long id;
    private String nameOfBusbar;
    private Integer amount;
    private Double module;
    private Double avgDailyActivePower;
    private Double avgDailyReactivePower;
    private Integer effectiveAmountOfEquipment;
    private Double coefficientMax;
    private Double maxActivePower;
    private Double maxReactivePower;
    private Double maxFullPower;
    private Double maxElectricCurrent;
    private Double powerOfGroup;
    private Double cosF;
    private Double tgF;
    private Double kI;
    private List<FullStartInformIdResponseDTO> fullStartInformIdResponseDTO;


    public FullInformationResponseDTO(FullInformation fullInformation) {
        id = fullInformation.getId();
        nameOfBusbar = fullInformation.getNameOfBusbar();
        amount = fullInformation.getAmount();
        module = fullInformation.getModule();
        avgDailyActivePower = fullInformation.getAvgDailyActivePower();
        avgDailyReactivePower = fullInformation.getAvgDailyReactivePower();
        effectiveAmountOfEquipment = fullInformation.getEffectiveAmountOfEquipment();
        coefficientMax = fullInformation.getCoefficientMax();
        maxActivePower = fullInformation.getMaxActivePower();
        maxReactivePower = fullInformation.getMaxReactivePower();
        maxFullPower = fullInformation.getMaxFullPower();
        maxElectricCurrent = fullInformation.getMaxElectricCurrent();
        powerOfGroup = fullInformation.getPowerOfGroup();
        cosF = fullInformation.getCosF();
        tgF = fullInformation.getTgF();
        kI = fullInformation.getkI();
        fullStartInformIdResponseDTO = fullInformation.getFullStartInformId().stream()
                .map(FullStartInformIdResponseDTO::new)
                .collect(Collectors.toList());
    }

    public FullInformationResponseDTO(Long id, String nameOfBusbar, Integer amount, Double module, Double avgDailyActivePower,
                                      Double avgDailyReactivePower, Integer effectiveAmountOfEquipment, Double coefficientMax,
                                      Double maxActivePower, Double maxReactivePower, Double maxFullPower, Double maxElectricCurrent,
                                      Double powerOfGroup, Double cosF, Double tgF, Double kI, List<FullStartInformIdResponseDTO> fullStartInformIdResponseDTO) {
        this.id = id;
        this.nameOfBusbar = nameOfBusbar;
        this.amount = amount;
        this.module = module;
        this.avgDailyActivePower = avgDailyActivePower;
        this.avgDailyReactivePower = avgDailyReactivePower;
        this.effectiveAmountOfEquipment = effectiveAmountOfEquipment;
        this.coefficientMax = coefficientMax;
        this.maxActivePower = maxActivePower;
        this.maxReactivePower = maxReactivePower;
        this.maxFullPower = maxFullPower;
        this.maxElectricCurrent = maxElectricCurrent;
        this.powerOfGroup = powerOfGroup;
        this.cosF = cosF;
        this.tgF = tgF;
        this.kI = kI;
        this.fullStartInformIdResponseDTO = fullStartInformIdResponseDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfBusbar() {
        return nameOfBusbar;
    }

    public void setNameOfBusbar(String nameOfBusbar) {
        this.nameOfBusbar = nameOfBusbar;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getModule() {
        return module;
    }

    public void setModule(Double module) {
        this.module = module;
    }

    public Double getAvgDailyActivePower() {
        return avgDailyActivePower;
    }

    public void setAvgDailyActivePower(Double avgDailyActivePower) {
        this.avgDailyActivePower = avgDailyActivePower;
    }

    public Double getAvgDailyReactivePower() {
        return avgDailyReactivePower;
    }

    public void setAvgDailyReactivePower(Double avgDailyReactivePower) {
        this.avgDailyReactivePower = avgDailyReactivePower;
    }

    public Integer getEffectiveAmountOfEquipment() {
        return effectiveAmountOfEquipment;
    }

    public void setEffectiveAmountOfEquipment(Integer effectiveAmountOfEquipment) {
        this.effectiveAmountOfEquipment = effectiveAmountOfEquipment;
    }

    public Double getCoefficientMax() {
        return coefficientMax;
    }

    public void setCoefficientMax(Double coefficientMax) {
        this.coefficientMax = coefficientMax;
    }

    public Double getMaxActivePower() {
        return maxActivePower;
    }

    public void setMaxActivePower(Double maxActivePower) {
        this.maxActivePower = maxActivePower;
    }

    public Double getMaxReactivePower() {
        return maxReactivePower;
    }

    public void setMaxReactivePower(Double maxReactivePower) {
        this.maxReactivePower = maxReactivePower;
    }

    public Double getMaxFullPower() {
        return maxFullPower;
    }

    public void setMaxFullPower(Double maxFullPower) {
        this.maxFullPower = maxFullPower;
    }

    public Double getMaxElectricCurrent() {
        return maxElectricCurrent;
    }

    public void setMaxElectricCurrent(Double maxElectricCurrent) {
        this.maxElectricCurrent = maxElectricCurrent;
    }

    public Double getPowerOfGroup() {
        return powerOfGroup;
    }

    public void setPowerOfGroup(Double powerOfGroup) {
        this.powerOfGroup = powerOfGroup;
    }

    public Double getCosF() {
        return cosF;
    }

    public void setCosF(Double cosF) {
        this.cosF = cosF;
    }

    public Double getTgF() {
        return tgF;
    }

    public void setTgF(Double tgF) {
        this.tgF = tgF;
    }

    public Double getkI() {
        return kI;
    }

    public void setkI(Double kI) {
        this.kI = kI;
    }

    public List<FullStartInformIdResponseDTO> getFullStartInformIdResponseDTO() {
        return fullStartInformIdResponseDTO;
    }

    public void setFullStartInformIdResponseDTO(List<FullStartInformIdResponseDTO> fullStartInformIdResponseDTO) {
        this.fullStartInformIdResponseDTO = fullStartInformIdResponseDTO;
    }
}
