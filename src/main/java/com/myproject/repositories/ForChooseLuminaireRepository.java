package com.myproject.repositories;


import com.myproject.entity.LuminaireSelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForChooseLuminaireRepository
        extends JpaRepository<LuminaireSelection, Long> {
}
