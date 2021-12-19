package com.example.book.service;

import com.example.book.dto.AuthorDTO;
import org.springframework.stereotype.Component;

import java.util.List;


public interface AuthorService {
    public List<AuthorDTO> getAuthors();
}
