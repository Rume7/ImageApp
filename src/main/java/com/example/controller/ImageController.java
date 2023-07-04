package com.example.controller;

import com.example.entities.Image;
import com.example.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/image")
@RequiredArgsConstructor
public class ImageController {

    private final ImageService imageService;

    @PostMapping("/create")
    public Image saveImage(@RequestBody Image image) {

        return null;
    }

    @PutMapping("/update/{id}")
    public Image updateImage(@RequestBody Image image, @PathVariable Long id) {
        return imageService.updateImage(image, id);
    }

    @GetMapping("")
    public List<Image> getImages() {
        return imageService.getAllImages();
    }

    @GetMapping
    public Image getImageById(@PathVariable Long imageId) {
        return imageService.getImageById(imageId);
    }

    @DeleteMapping
    public void deleteImage(@PathVariable Long imageId) {
        imageService.deleteImageById(imageId);
    }
}
