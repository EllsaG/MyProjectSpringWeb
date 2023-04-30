package com.myproject.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "cables")
public class Cables {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "cable_type", nullable = false)
    @Setter
    private String cableType;

    public Cables(String cableType) {
        this.cableType = cableType;
    }
}
