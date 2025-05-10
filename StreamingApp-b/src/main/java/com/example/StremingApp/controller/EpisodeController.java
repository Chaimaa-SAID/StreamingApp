package com.example.StremingApp.controller;

import com.example.StremingApp.model.Episode;
import com.example.StremingApp.service.EpisodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    // Upload vidéo pour un épisode
    @PostMapping("/{id}/upload-video")
    public Episode uploadVideo(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        return episodeService.uploadVideoToEpisode(id, file);
    }
}
