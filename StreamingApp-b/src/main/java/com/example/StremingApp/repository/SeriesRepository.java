package com.example.StremingApp.repository;

import com.example.StremingApp.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository <Serie, Long> {
}
