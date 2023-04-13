package com.myproject.entity;

import javax.persistence.*;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getRatedPowerForChoosingOfTransformer() {
        return ratedPowerForChoosingOfTransformer;
    }

    public void setRatedPowerForChoosingOfTransformer(double ratedPowerForChoosingOfTransformer) {
        this.ratedPowerForChoosingOfTransformer = ratedPowerForChoosingOfTransformer;
    }
}
