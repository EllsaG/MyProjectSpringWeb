package com.myproject.repositories;

import com.myproject.entity.StartInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StartInformationRepository
        extends JpaRepository <StartInformation, Long> {

}
