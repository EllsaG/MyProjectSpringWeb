package com.myproject.repositories;

import com.myproject.entity.TransformerSelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForChooseTransformersRepository
        extends JpaRepository<TransformerSelection, Long> {
}
