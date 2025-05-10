package com.example.StremingApp.repository;

import com.example.StremingApp.model.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository <Series, Long> {
}
