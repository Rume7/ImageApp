package com.example.service;

import com.example.dto.ImageDTO;
import com.example.entities.Image;
import com.example.entities.Tag;
import com.example.repositories.ImageRepository;
import com.example.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    @Autowired
    private final ImageRepository imageRepository;

    @Autowired
    private final TagRepository tagRepository;

    @Override
    public Image createImage(ImageDTO image) {
        List<Tag> allTags = mapTagsToList(image.tags());
        Image img = new Image(image.name(), allTags);
        img.setTags(allTags);
        //tagRepository.save(allTags);
        Image imgGotten = imageRepository.save(img);
        return img;
    }

    private List<Tag> mapTagsToList(Set<Tag> tags) {

        return null;
    }

    @Override
    public Image updateImage(Image imageDTO, Long id) {
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
