package com.example.StremingApp.repository;

import com.example.StremingApp.model.VideoFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoFileRepository extends JpaRepository<VideoFile, Long> {
}
