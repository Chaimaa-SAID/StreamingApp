package com.example.StremingApp.service;

import com.example.StremingApp.model.Episode;
import com.example.StremingApp.model.Movie;
import com.example.StremingApp.model.VideoFile;
import com.example.StremingApp.repository.EpisodeRepository;
import com.example.StremingApp.repository.MovieRepository;
import com.example.StremingApp.repository.VideoFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class VideoFileService {

    @Autowired
    private VideoFileRepository videoFileRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    // Chemins des dossiers de stockage des vidéos
    private final String baseMoviePath = "C:/videos/movies/";
    private final String baseEpisodePath = "C:/videos/episodes/";

    // Sauvegarde une vidéo pour un film
    public VideoFile saveVideoFileForMovie(Long movieId, MultipartFile file) throws IOException {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Film introuvable"));

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filePath = baseMoviePath + fileName;

        // Crée le dossier si nécessaire
        File dir = new File(baseMoviePath);
        if (!dir.exists()) dir.mkdirs();

        // Sauvegarde la vidéo sur le disque
        file.transferTo(new File(filePath));

        // Crée et enregistre l'objet VideoFile
        VideoFile videoFile = new VideoFile();
        videoFile.setFileName(fileName);
        videoFile.setFileType(file.getContentType());
        videoFile.setFilePath(filePath); // Stocke le chemin du fichier
        videoFile.setMovie(movie);

        return videoFileRepository.save(videoFile);
    }

    // Sauvegarde une vidéo pour un épisode
    public VideoFile saveVideoFileForEpisode(Long episodeId, MultipartFile file) throws IOException {
        Episode episode = episodeRepository.findById(episodeId)
                .orElseThrow(() -> new RuntimeException("Épisode introuvable"));

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        String filePath = baseEpisodePath + fileName;

        // Crée le dossier si nécessaire
        File dir = new File(baseEpisodePath);
        if (!dir.exists()) dir.mkdirs();

        // Sauvegarde la vidéo sur le disque
        file.transferTo(new File(filePath));

        // Crée et enregistre l'objet VideoFile
        VideoFile videoFile = new VideoFile();
        videoFile.setFileName(fileName);
        videoFile.setFileType(file.getContentType());
        videoFile.setFilePath(filePath); // Stocke le chemin du fichier
        videoFile.setEpisode(episode);

        return videoFileRepository.save(videoFile);
    }
}
