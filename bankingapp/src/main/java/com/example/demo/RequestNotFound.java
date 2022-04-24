package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestNotFound extends RuntimeException {
	    public  RequestNotFound(String message){
	        super(message);
	    }
	    public RequestNotFound(String message, Throwable cause){
	        super(message, cause);
	    }
	}


