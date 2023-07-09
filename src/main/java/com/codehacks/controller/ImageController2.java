package com.codehacks.controller;

import com.codehacks.entities.Media;
import com.codehacks.service.ImageService2;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/images")
public class ImageController2 {

    private final ImageService2 imageService;

    @PostMapping("/{customerId}/upload")
    public ResponseEntity<Media> uploadImage(@PathVariable("customerId") UUID customerId,
                                             @RequestParam("image") MultipartFile image) {
        Media media = imageService.uploadImageForCustomer(customerId, image);
        return new ResponseEntity<>(media, HttpStatus.CREATED);
    }
}
