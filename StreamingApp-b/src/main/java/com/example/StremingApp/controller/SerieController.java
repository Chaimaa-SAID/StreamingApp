package com.example.StremingApp.controller;

import com.example.StremingApp.model.Serie;
import com.example.StremingApp.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/series")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class SerieController {

    private final SeriesService seriesService;

    @GetMapping
    public List<Serie> getAll() {
        return seriesService.getAll();
    }

    @GetMapping("/{id}")
    public Serie getById(@PathVariable Long id) {
        return seriesService.getById(id);
    }

    @PostMapping
    public Serie create(@RequestBody Serie serie) {
        return seriesService.create(serie);
    }

    @PutMapping("/{id}")
    public Serie update(@PathVariable Long id, @RequestBody Serie serie) {
        return seriesService.update(id, serie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        seriesService.delete(id);
    }
}
