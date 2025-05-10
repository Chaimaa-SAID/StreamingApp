package com.example.StremingApp.controller;

import com.example.StremingApp.model.Media;
import com.example.StremingApp.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/media")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class MediaAdminController {
    private final MediaService mediaService;

    @GetMapping
    public List<Media> getAll() {
        return mediaService.getAll();
    }

    @GetMapping("/{id}")
    public Media getById(@PathVariable Long id) {
        return mediaService.getById(id);
    }

    @PostMapping
    public Media create(@RequestBody Media media) {
        return mediaService.create(media);
    }

    @PutMapping("/{id}")
    public Media update(@PathVariable Long id, @RequestBody Media media) {
        return mediaService.update(id, media);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mediaService.delete(id);
    }
}
