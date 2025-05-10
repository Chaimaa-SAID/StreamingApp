package com.example.StremingApp.service;

import com.example.StremingApp.model.Theme;
import com.example.StremingApp.repository.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeService {
    private final ThemeRepository themeRepository;

    public List<Theme> getAll() {
        return themeRepository.findAll();
    }

    public Theme create(Theme theme) {
        return themeRepository.save(theme);
    }

    public Theme update(Long id, Theme updated) {
        Theme existing = themeRepository.findById(id).orElseThrow();
        existing.setNom(updated.getNom()); // adapte selon les champs
        return themeRepository.save(existing);
    }

    public void delete(Long id) {
        themeRepository.deleteById(id);
    }
}
