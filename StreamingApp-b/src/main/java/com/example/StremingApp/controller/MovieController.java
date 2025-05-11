package com.example.StremingApp.controller;

import com.example.StremingApp.model.Media;
import com.example.StremingApp.model.Movie;
import com.example.StremingApp.model.VideoFile;
import com.example.StremingApp.service.FileStorageService;
import com.example.StremingApp.service.MediaService;
import com.example.StremingApp.service.MovieService;
import com.example.StremingApp.service.VideoFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/admin/movies")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class MovieController {

    private final MovieService movieService;
    private final VideoFileService videoFileService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieService.getById(id);
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie) {
        return movieService.create(movie);
    }

    @PutMapping("/{id}")
    public Movie update(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        return movieService.update(id, updatedMovie);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }
    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadVideo(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        Movie movie = movieService.getById(id);
        if (movie == null) {
            return ResponseEntity.badRequest().body("Movie not found with ID: " + id);
        }

        // Utilise le service VideoFile pour stocker la vidéo
        VideoFile videoFile = videoFileService.saveVideoFileForMovie(id, file);

        // Met à jour l'URL de streaming du film
        movie.setUrlStreaming("movies/" + videoFile.getFileName());
        movieService.save(movie);

        return ResponseEntity.ok("Video uploaded for movie: " + videoFile.getFileName());
    }
}
