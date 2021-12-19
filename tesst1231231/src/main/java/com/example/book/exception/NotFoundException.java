package com.example.book.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg)
    {
        super(msg);
    }
}
