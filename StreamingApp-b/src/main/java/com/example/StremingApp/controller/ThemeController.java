package com.example.StremingApp.controller;


import com.example.StremingApp.model.Theme;
import com.example.StremingApp.service.ThemeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/themes")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class ThemeController {
    private final ThemeService themeService;

    @GetMapping
    public List<Theme> getAll() {
        return themeService.getAll();
    }

    @PostMapping
    public Theme create(@RequestBody Theme theme) {
        return themeService.create(theme);
    }

    @PutMapping("/{id}")
    public Theme update(@PathVariable Long id, @RequestBody Theme theme) {
        return themeService.update(id, theme);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        themeService.delete(id);
    }
}
