package com.example.StremingApp.controller;


import com.example.StremingApp.model.Theme;
import com.example.StremingApp.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
public class ThemeController {
    @Autowired
    private ThemeService themeService;

    @GetMapping
    public List<Theme> getAllThemes() {
        return themeService.getAllThemes();
    }

    @PostMapping
    public Theme saveTheme(@RequestBody Theme theme) {
        return themeService.saveTheme(theme);
    }
}
