package com.myproject.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "for_choose_transformers")
public class ForChooseTransformers {
    @Id
    @Column(name = "id", nullable = false)
    private long id;

    @Column(name = "rated_power_for_choosing_of_transformer", nullable = false)
    private double ratedPowerForChoosingOfTransformer;

    public ForChooseTransformers(long id, double ratedPowerForChoosingOfTransformer) {
        this.id = id;
        this.ratedPowerForChoosingOfTransformer = ratedPowerForChoosingOfTransformer;
    }

    public ForChooseTransformers() {

    }

}
