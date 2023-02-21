package com.myproject.controller.dto.fullinformation.postget;

import com.myproject.entity.FullStartInformId;



public class FullStartInformIdResponseDTO {
    private Long id;
    private Long fullInformationId;
    private Long startInformId;
    private Integer amount;


    public FullStartInformIdResponseDTO(FullStartInformId fullStartInformId) {
        id = fullStartInformId.getId();
        fullInformationId = fullStartInformId.getFullInformationId();
        startInformId = fullStartInformId.getStartInformId();
        amount = fullStartInformId.getAmount();
    }


    public FullStartInformIdResponseDTO(Long id, Long fullInformationId, Long startInformId, Integer amount) {
        this.id = id;
        this.fullInformationId = fullInformationId;
        this.startInformId = startInformId;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFullInformationId() {
        return fullInformationId;
    }

    public void setFullInformationId(Long fullInformationId) {
        this.fullInformationId = fullInformationId;
    }

    public Long getStartInformId() {
        return startInformId;
    }

    public void setStartInformId(Long startInformId) {
        this.startInformId = startInformId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
