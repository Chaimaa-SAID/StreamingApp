package com.example.StremingApp.service;

import com.example.StremingApp.model.Episode;
import com.example.StremingApp.model.Season;
import com.example.StremingApp.repository.EpisodeRepository;
import com.example.StremingApp.repository.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final SeasonRepository seasonRepository;

    public List<Episode> getAll() {
        return episodeRepository.findAll();
    }

    public Episode getById(Long id) {
        return episodeRepository.findById(id).orElseThrow();
    }

    public Episode create(Episode episode, Long seasonId) {
        Season season = seasonRepository.findById(seasonId).orElseThrow();
        episode.setSeason(season);
        return episodeRepository.save(episode);
    }

    public Episode update(Long id, Episode updated) {
        Episode existing = getById(id);
        existing.setTitre(updated.getTitre());
        existing.setNumero(updated.getNumero());
        existing.setDuree(updated.getDuree());
        existing.setUrlStreaming(updated.getUrlStreaming());
        return episodeRepository.save(existing);
    }

    public void delete(Long id) {
        episodeRepository.deleteById(id);
    }
    public Episode uploadVideoToEpisode(Long episodeId, MultipartFile file) throws IOException {
        Episode episode = getById(episodeId);

        String uploadDir = "videos/";
        Files.createDirectories(Paths.get(uploadDir));

        String filename = file.getOriginalFilename();
        Path filepath = Paths.get(uploadDir, filename);
        Files.write(filepath, file.getBytes());

        episode.setUrlStreaming("/videos/" + filename); // Chemin d'accès
        return episodeRepository.save(episode);
    }
}

