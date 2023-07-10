package com.codehacks.entities;

public record Person(String firstName, String lastName) {

    @Override
    public String toString() {
        return firstName + " " + lastName ;
    }
}
