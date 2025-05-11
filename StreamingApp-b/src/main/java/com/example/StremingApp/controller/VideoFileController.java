package com.example.StremingApp.controller;

import com.example.StremingApp.model.VideoFile;
import com.example.StremingApp.service.VideoFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/video")
public class VideoFileController {

    @Autowired
    private VideoFileService videoFileService;

    @PostMapping("/movie/{movieId}")
    public ResponseEntity<VideoFile> uploadVideoForMovie(@PathVariable Long movieId,
                                                         @RequestParam("file") MultipartFile file) {
        try {
            VideoFile videoFile = videoFileService.saveVideoFileForMovie(movieId, file);
            return ResponseEntity.ok(videoFile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/episode/{episodeId}")
    public ResponseEntity<VideoFile> uploadVideoForEpisode(@PathVariable Long episodeId,
                                                           @RequestParam("file") MultipartFile file) {
        try {
            VideoFile videoFile = videoFileService.saveVideoFileForEpisode(episodeId, file);
            return ResponseEntity.ok(videoFile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
