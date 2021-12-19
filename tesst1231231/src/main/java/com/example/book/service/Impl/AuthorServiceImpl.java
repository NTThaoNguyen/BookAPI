package com.example.book.service.Impl;

import com.example.book.dto.AuthorDTO;
import com.example.book.repository.AuthorRepository;
import com.example.book.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public List<AuthorDTO> getAuthors() {
        return authorRepository.findAll().stream().map(AuthorDTO::new)
                .collect(Collectors.toList());
    }
}
