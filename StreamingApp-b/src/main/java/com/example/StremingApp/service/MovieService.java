package com.example.StremingApp.service;

import com.example.StremingApp.model.Movie;
import com.example.StremingApp.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    public Movie create(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie update(Long id, Movie updatedMovie) {
        Movie existing = getById(id);
        existing.setTitre(updatedMovie.getTitre());
        existing.setDuree(updatedMovie.getDuree());
        existing.setUrlStreaming(updatedMovie.getUrlStreaming());
        return movieRepository.save(existing);
    }

    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }
}
