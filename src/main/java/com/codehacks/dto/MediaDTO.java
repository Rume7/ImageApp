package com.codehacks.dto;

import com.codehacks.entities.Customer;
import com.codehacks.entities.Tag;

import java.time.LocalDateTime;
import java.util.Set;

public record MediaDTO(Integer id, String type, LocalDateTime dateTimeCreated,
                       Set<Tag> tags, Customer customer) {
}
