package com.example.StremingApp.controller;

import com.example.StremingApp.model.Season;
import com.example.StremingApp.service.SeasonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/seasons")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class SeasonController {

    private final SeasonService seasonService;

    @GetMapping
    public List<Season> getAll() {
        return seasonService.getAll();
    }

    @GetMapping("/{id}")
    public Season getById(@PathVariable Long id) {
        return seasonService.getById(id);
    }

    @PostMapping
    public Season create(@RequestBody Season season, @RequestParam Long seriesId) {
        return seasonService.create(season, seriesId);
    }

    @PutMapping("/{id}")
    public Season update(@PathVariable Long id, @RequestBody Season season) {
        return seasonService.update(id, season);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        seasonService.delete(id);
    }
}
