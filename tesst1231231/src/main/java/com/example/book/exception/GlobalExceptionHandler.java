package com.example.book.exception;

import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = DuplicateException.class)
    protected ResponseEntity<Object> DuplicateException(DuplicateException e)
    {
        return new Error(409,"Conflict",e.getMessage(), HttpStatus.CONFLICT).generateResponseEntity();
    }
    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<Object> NotFoundException(NotFoundException e)
    {
        return new Error(404,"Not found",e.getMessage(), HttpStatus.NOT_FOUND).generateResponseEntity();
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> ValidException(MethodArgumentNotValidException e)
    {
        StringBuilder error=new StringBuilder("");
        for (ObjectError x:e.getBindingResult().getAllErrors()) {
            error.append(x.getDefaultMessage()+"\n");
        }
        return new Error(400,"Validation",error.toString(), HttpStatus.BAD_REQUEST).generateResponseEntity();
    }
    @ExceptionHandler(value = EntityExistsException.class)
    protected ResponseEntity<Object> EntityExistsException(EntityExistsException e)
    {
        return new Error(409,"Entity Exists",e.getMessage(), HttpStatus.CONFLICT).generateResponseEntity();
    }
}
