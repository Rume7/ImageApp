package com.codehacks.exception;

public class ResourceNotFoundException extends RuntimeException{
    
    public ResourceNotFoundException() {
        String message = "Resource not found";
    }
}
