package com.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "high_volt_cables")
public class HighVoltCables {


    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "cable_type", nullable = false)
    @Setter
    private String cableType;

}
