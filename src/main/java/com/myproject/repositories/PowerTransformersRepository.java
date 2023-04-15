package com.myproject.repositories;

import com.myproject.entity.PowerTransformers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PowerTransformersRepository
        extends JpaRepository<PowerTransformers, Long> {
}
