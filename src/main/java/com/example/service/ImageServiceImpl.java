package com.example.service;

import com.example.entities.Image;
import com.example.repositories.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Autowired
    private final ImageRepository imageRepository;

    @Override
    public Image createImage(Image image) {
        Image img = imageRepository.save(image);
        return img;
    }

    @Override
    public Image updateImage(Image image) {
        return null;
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImageById(Long id) {
        Optional<Image> imageFound = imageRepository.findById(id);
        if (imageFound.isPresent()) {
            return imageFound.get();
        }
        return null;
    }

    @Override
    public void deleteImageById(Long id) {
        Optional<Image> gottenImage = imageRepository.findById(id);
        if (!gottenImage.isEmpty()) {
            imageRepository.deleteById(id);
        }
    }
}
