package com.example.service;

import com.example.entities.Image;

import java.util.List;

public interface ImageService {

    Image createImage(Image image);

    Image updateImage(Image image);

    List<Image> getAllImages() ;

    Image getImageById(Long id);

    void deleteImageById(Long id);

}
