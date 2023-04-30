package com.myproject.repositories;

import com.myproject.entity.Cables;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CablesRepository
extends JpaRepository<Cables, Long> {
}
