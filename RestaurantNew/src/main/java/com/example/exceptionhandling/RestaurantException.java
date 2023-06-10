package com.example.exceptionhandling;

public class RestaurantException extends Exception {
	
public RestaurantException() {
		
	}
	
	
    public RestaurantException(String message) {
        super(message);
    }
}