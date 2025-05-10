package com.example.StremingApp.service;

import com.example.StremingApp.model.Series;
import com.example.StremingApp.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeriesService {
    private final SeriesRepository seriesRepository;

    public List<Series> getAll() {
        return seriesRepository.findAll();
    }

    public Series getById(Long id) {
        return seriesRepository.findById(id).orElseThrow();
    }

    public Series create(Series series) {
        return seriesRepository.save(series);
    }

    public Series update(Long id, Series updated) {
        Series existing = getById(id);
        existing.setNom(updated.getNom());
        existing.setNombreSaisons(updated.getNombreSaisons());
        return seriesRepository.save(existing);
    }

    public void delete(Long id) {
        seriesRepository.deleteById(id);
    }
}
