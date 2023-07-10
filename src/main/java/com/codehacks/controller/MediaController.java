package com.codehacks.controller;

import com.codehacks.dto.MediaDTO;
import com.codehacks.dto.TagDTO;
import com.codehacks.entities.Media;
import com.codehacks.entities.Person;
import com.codehacks.entities.Tag;
import com.codehacks.service.MediaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/media")
public class MediaController {

    private final MediaService mediaService;

    @PostMapping("/{custId}/upload")
    public ResponseEntity<MediaDTO> uploadImage(@PathVariable("custId") Integer custId,
            @RequestParam("image") MultipartFile image) throws IOException {
        MediaDTO media = mediaService.uploadImageForCustomer(custId, image);
        return new ResponseEntity<>(media, HttpStatus.CREATED);
    }

    @PostMapping("/{mediaId}/tag")
    public ResponseEntity<Set<TagDTO>> tagAnImage(@RequestBody List<Person> names,
                                                  @PathVariable("mediaId") Integer mediaId) {
        Set<TagDTO> tags = mediaService.tagAnImage(names, mediaId);
        return new ResponseEntity<>(tags, HttpStatus.CREATED);
    }
}
