package com.example.freebooks;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BooksException extends RuntimeException{
    public BooksException(String message){
        super(message);
    }
}

