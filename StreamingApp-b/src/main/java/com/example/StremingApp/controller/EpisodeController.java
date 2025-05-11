package com.example.StremingApp.controller;

import com.example.StremingApp.model.Episode;
import com.example.StremingApp.model.VideoFile;
import com.example.StremingApp.service.EpisodeService;
import com.example.StremingApp.service.VideoFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/admin/episodes")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class EpisodeController {

    private final EpisodeService episodeService;

    @GetMapping
    public List<Episode> getAll() {
        return episodeService.getAll();
    }

    @GetMapping("/{id}")
    public Episode getById(@PathVariable Long id) {
        return episodeService.getById(id);
    }

    @PostMapping
    public Episode create(@RequestBody Episode episode, @RequestParam Long seasonId) {
        return episodeService.create(episode, seasonId);
    }

    @PutMapping("/{id}")
    public Episode update(@PathVariable Long id, @RequestBody Episode episode) {
        return episodeService.update(id, episode);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        episodeService.delete(id);
    }


    @PostMapping("/{id}/upload-video")
    public ResponseEntity<String> uploadVideo(
            @PathVariable Long id,
            @RequestParam("file") MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            Path targetLocation = Paths.get("C:/videos/episodes/" + fileName);
            Files.copy(file.getInputStream(), targetLocation);
            episodeService.uploadVideoFromLocalPath(id, fileName);
            return ResponseEntity.ok("Video uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error uploading file: " + e.getMessage());
        }
    }
}
