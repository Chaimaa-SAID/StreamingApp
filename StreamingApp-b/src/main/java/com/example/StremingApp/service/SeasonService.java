package com.example.StremingApp.service;

import com.example.StremingApp.model.Season;
import com.example.StremingApp.model.Serie;
import com.example.StremingApp.repository.SeasonRepository;
import com.example.StremingApp.repository.SeriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeasonService {
    private final SeasonRepository seasonRepository;
    private final SeriesRepository seriesRepository;

    public List<Season> getAll() {
        return seasonRepository.findAll();
    }

    public Season getById(Long id) {
        return seasonRepository.findById(id).orElseThrow(() -> new RuntimeException("Season not found"));
    }

    public Season create(Season season, Long seriesId) {
        Serie serie = seriesRepository.findById(seriesId).orElseThrow(() -> new RuntimeException("Serie not found"));
        season.setSerie(serie);
        return seasonRepository.save(season);
    }

    public Season update(Long id, Season updated) {
        Season existing = getById(id);
        existing.setNumber(updated.getNumber());
        existing.setReleaseDate(updated.getReleaseDate());
        return seasonRepository.save(existing);
    }

    public void delete(Long id) {
        seasonRepository.deleteById(id);
    }
}
