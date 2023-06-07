package com.myproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transformer_selection")
public class TransformerSelection {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "rated_power_for_transformer_selection", nullable = false)
    private double ratedPowerForTransformerSelection;

}
