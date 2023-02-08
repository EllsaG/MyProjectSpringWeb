package com.myproject.repository;

import com.myproject.entity.StartInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository
        extends JpaRepository <StartInformation, Long> {

}
