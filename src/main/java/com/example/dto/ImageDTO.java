package com.example.dto;

import com.example.entities.Tag;

import java.util.Set;

public record ImageDTO (String name, Set<Tag> tags) {

}
