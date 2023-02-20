package com.myproject.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "full_start_inform_id")
public class FullStartInformId {
    @Id
    @Column(name = "f_s_inform_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "full_information_id", nullable = false)
    private Long fullInformationId;


    @Column(name = "start_inform_id", nullable = false)
    private Long startInformId;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    public FullStartInformId(Long fullInformationId, Long startInformId, Integer amount) {
        this.fullInformationId = fullInformationId;
        this.startInformId = startInformId;
        this.amount = amount;
    }

    public FullStartInformId() {
    }

    public Long getId() {
        return id;
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