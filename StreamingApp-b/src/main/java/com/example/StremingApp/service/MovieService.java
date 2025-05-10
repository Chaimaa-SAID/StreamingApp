package com.example.StremingApp.service;

import com.example.StremingApp.model.Movie;
import com.example.StremingApp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie update(Long id, Movie updated) {
        Movie existing = movieRepository.findById(id).orElseThrow();
        existing.setTitre(updated.getTitre());
        existing.setDuree(updated.getDuree());
        existing.setUrlStreaming(updated.getUrlStreaming());
        return movieRepository.save(existing);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
    // Trouver un film par ID
    public Movie findById(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.orElse(null);
    }

    // Sauvegarder ou mettre à jour un film
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
}

}
