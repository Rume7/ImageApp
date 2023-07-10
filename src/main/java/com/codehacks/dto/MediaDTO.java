package com.codehacks.dto;

import com.codehacks.entities.Customer;
import com.codehacks.entities.Tag;

import java.time.LocalDateTime;
import java.util.Set;

public record MediaDTO(String name, LocalDateTime localDateTime,
                       Set<Tag> tags, Customer customer) {
}
