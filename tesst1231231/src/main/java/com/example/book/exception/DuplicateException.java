package com.example.book.exception;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String msg)
    {
        super(msg);
    }
}
