package com.example.StremingApp.repository;

import com.example.StremingApp.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
