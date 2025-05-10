package com.example.StremingApp.controller;

import com.example.StremingApp.model.Media;
import com.example.StremingApp.model.Movie;
import com.example.StremingApp.service.FileStorageService;
import com.example.StremingApp.service.MediaService;
import com.example.StremingApp.service.MovieService;
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

    private final MediaService mediaService;
    private final MovieService movieService;
    private final FileStorageService fileStorageService;

    // Get all movies
    @GetMapping
    public List<Media> getAll() {
        return mediaService.getAll();
    }

    // Create a new movie
    @PostMapping
    public Media create(@RequestBody Media movie) {
        return mediaService.create(movie);
    }

    // Update movie
    @PutMapping("/{id}")
    public Media update(@PathVariable Long id, @RequestBody Media movie) {
        return mediaService.update(id, movie);
    }

    // Delete movie
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        mediaService.delete(id);
    }


    @PostMapping("/{id}/upload")
    public ResponseEntity<String> uploadVideo(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        Movie movie = movieService.findById(id);
        if (movie == null) {
            return ResponseEntity.badRequest().body("Film introuvable avec l'id : " + id);
        }

        String uploadDir = "C:/videos/movies/";
        new File(uploadDir).mkdirs(); // Crée le dossier s'il n'existe pas

        String fileName = file.getOriginalFilename();
        File destination = new File(uploadDir + fileName);
        file.transferTo(destination);

        movie.setUrlStreaming("movies/" + fileName);
        movieService.save(movie);

        return ResponseEntity.ok("Vidéo uploadée et liée au film : " + fileName);
    }


}