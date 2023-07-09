package com.codehacks.service;

import com.codehacks.dto.ImageDTO;
import com.codehacks.entities.Image;

import java.util.List;

public interface ImageService {

    Image createImage(ImageDTO image);


    Image updateImage(ImageDTO image, Long id);

    List<Image> getAllImages() ;

    Image getImageById(Long id);

    void deleteImageById(Long id);

}
