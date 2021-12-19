package com.example.book.service;

import com.example.book.payload.request.LoginRequest;
import org.springframework.http.ResponseEntity;

public interface AuthService {
    ResponseEntity<?> authenticateUser(LoginRequest loginRequest);
}
