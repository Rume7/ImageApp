package com.codehacks.dto;

public record TagDTO(Integer id, String name) {

    @Override
    public String toString() {
        return "id = " + id + " name = " + name;
    }
}
