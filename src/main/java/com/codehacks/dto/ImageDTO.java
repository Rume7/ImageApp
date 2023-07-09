package com.codehacks.dto;

import com.codehacks.entities.Tag;

import java.util.List;

public record ImageDTO (String name, List<Tag> tags) {

}
