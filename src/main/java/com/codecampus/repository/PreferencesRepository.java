package com.codecampus.repository;

import com.codecampus.dto.HomeDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferencesRepository extends JpaRepository<HomeDto,Long> {

    HomeDto findByUserId(Long userId);
}
