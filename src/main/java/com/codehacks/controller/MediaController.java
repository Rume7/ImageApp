package com.codehacks.controller;

import com.codehacks.entities.Media;
import com.codehacks.service.MediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/images")
public class MediaController {

    private final MediaService imageService;

    @PostMapping("/{customerId}/upload")
    public ResponseEntity<Media> uploadImage(@PathVariable("customerId") UUID customerId,
            @RequestParam("image") MultipartFile image) throws IOException {
        Media media = imageService.uploadImageForCustomer(customerId, image);
        return new ResponseEntity<>(media, HttpStatus.CREATED);
    }
}
