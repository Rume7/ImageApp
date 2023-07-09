package com.codehacks.dto;

import com.codehacks.entities.Media;

import java.util.Set;

public record CustomerDTO(String name, Set<Media> mediaSet) {

}
