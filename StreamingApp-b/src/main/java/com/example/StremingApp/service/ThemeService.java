package com.example.StremingApp.service;


import com.example.StremingApp.model.Theme;
import com.example.StremingApp.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ThemeService {
    @Autowired
    private ThemeRepository themeRepository;

    public List<Theme> getAllThemes() {
        return themeRepository.findAll();
    }

    public Theme saveTheme(Theme theme) {
        return themeRepository.save(theme);
    }
}

