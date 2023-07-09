package com.codehacks.controller;

import com.codehacks.dto.ImageDTO;
import com.codehacks.entities.Image;
import com.codehacks.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping(path = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Image> saveImage(@RequestBody ImageDTO imageDto) {
        Image img1 = imageService.createImage(imageDto);
        return new ResponseEntity<>(img1, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Image updateImage(@RequestBody ImageDTO image, @PathVariable Long id) {
        return imageService.updateImage(image, id);
    }

    @GetMapping("/all")
    public List<Image> getImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{imageId}")
    public Image getImageById(@PathVariable Long imageId) {
        return imageService.getImageById(imageId);
    }

    @DeleteMapping("/{imageId}")
    public void deleteImage(@PathVariable Long imageId) {
        imageService.deleteImageById(imageId);
    }
}
