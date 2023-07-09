package com.codehacks.service;

import com.codehacks.dto.ImageDTO;
import com.codehacks.entities.Image;
import com.codehacks.entities.Tag;
import com.codehacks.repositories.ImageRepository;
import com.codehacks.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Transactional
public class ImageServiceImpl implements ImageService {

    @Autowired
    private final ImageRepository imageRepository;

    @Autowired
    private final TagRepository tagRepository;

    @Override
    public Image createImage(ImageDTO image) {
        List<Tag> images = image.tags();
        Image img = new Image();
        img.setName(image.name());
        img.setTags(image.tags());
        tagRepository.saveAllAndFlush(images);

        Image imgGotten = imageRepository.save(img);
        return imgGotten;
    }

    private List<Tag> mapTagsToList(Set<Tag> tags) {
        List<Tag> tagList = new ArrayList<>(tags);
        return tagList;
    }

    @Override
    public Image updateImage(ImageDTO imageDTO, Long id) {
        Optional<Image> imageFound = imageRepository.findById(id);
        if (imageFound.isPresent()) {
            Image imageRetrieved = imageFound.get();
            imageRetrieved.setName(imageDTO.name());
            imageRetrieved.setTags(imageDTO.tags());
            return imageRetrieved;
        }
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