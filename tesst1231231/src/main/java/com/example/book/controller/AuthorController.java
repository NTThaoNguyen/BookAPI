package com.example.book.controller;

import com.example.book.dto.AuthorDTO;
import com.example.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @GetMapping
    public List<AuthorDTO> getAuthors() {
        return authorService.getAuthors();
    }
}
