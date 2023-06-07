package com.myproject.repositories;

import com.myproject.entity.HighVoltCableSelection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ForChooseHighVoltCableRepository
        extends JpaRepository<HighVoltCableSelection, Long> {
}