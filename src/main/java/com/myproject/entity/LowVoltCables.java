package com.myproject.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "low_volt_cables")
public class LowVoltCables {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "cable_type", nullable = false)
    @Setter
    private String cableType;

    public LowVoltCables(String cableType) {
        this.cableType = cableType;
    }
}
