package com.example.service;

import com.example.dto.ImageDTO;
import com.example.entities.Image;

import java.util.List;

public interface ImageService {

    Image createImage(ImageDTO image);

    Image updateImage(Image image, Long id);

    List<Image> getAllImages() ;

    Image getImageById(Long id);

    void deleteImageById(Long id);

}
