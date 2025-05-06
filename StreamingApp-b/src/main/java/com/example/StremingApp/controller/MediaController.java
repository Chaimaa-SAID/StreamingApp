package com.example.StremingApp.controller;

import com.example.StremingApp.model.Media;
import com.example.StremingApp.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    @Autowired
    private MediaService mediaService;

    @GetMapping
    public List<Media> getAllMedia() {
        return mediaService.getAllMedia();
    }

    @PostMapping
    public Media saveMedia(@RequestBody Media media) {
        return mediaService.saveMedia(media);
    }
}

