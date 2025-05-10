package com.example.StremingApp.service;


import com.example.StremingApp.model.Media;
import com.example.StremingApp.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService {
    private final MediaRepository mediaRepository;

    public List<Media> getAll() {
        return mediaRepository.findAll();
    }

    public Media getById(Long id) {
        return mediaRepository.findById(id).orElseThrow();
    }

    public Media create(Media media) {
        return mediaRepository.save(media);
    }

    public Media update(Long id, Media updatedMedia) {
        Media existing = getById(id);
        existing.setTitre(updatedMedia.getTitre());
        existing.setDescription(updatedMedia.getDescription());
        existing.setLangue(updatedMedia.getLangue());
        existing.setDateSortie(updatedMedia.getDateSortie());
        return mediaRepository.save(existing);
    }

    public void delete(Long id) {
        mediaRepository.deleteById(id);
    }
}

