package com.example.StremingApp.service;


import com.example.StremingApp.model.Media;
import com.example.StremingApp.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MediaService {
    @Autowired
    private MediaRepository mediaRepository;

    public List<Media> getAllMedia() {
        return mediaRepository.findAll();
    }

    public Media saveMedia(Media media) {
        return mediaRepository.save(media);
    }
}
