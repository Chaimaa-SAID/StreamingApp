package com.example.StremingApp.service;

import com.example.StremingApp.model.Serie;
import com.example.StremingApp.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final SeriesRepository seriesRepository;

    public List<Serie> getAll() {
        return seriesRepository.findAll();
    }

    public Serie getById(Long id) {
        return seriesRepository.findById(id).orElseThrow(() -> new RuntimeException("Serie not found"));
    }

    public Serie create(Serie series) {
        return seriesRepository.save(series);
    }

    public Serie update(Long id, Serie updated) {
        Serie existing = getById(id);
        existing.setNom(updated.getNom());
        existing.setNombreSaisons(updated.getNombreSaisons());
        return seriesRepository.save(existing);
    }

    public void delete(Long id) {
        seriesRepository.deleteById(id);
    }
}
