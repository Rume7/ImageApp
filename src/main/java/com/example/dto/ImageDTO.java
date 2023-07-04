package com.example.dto;

import com.example.entities.Tag;

import java.util.List;

public record ImageDTO (String name, List<Tag> tags) {

}
