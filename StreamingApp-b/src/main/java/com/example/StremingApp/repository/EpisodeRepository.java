package com.example.StremingApp.repository;

import com.example.StremingApp.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
