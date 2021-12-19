package com.example.book.controller;

import com.example.book.dto.NXBDTO;
import com.example.book.service.NXBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/NXBs")
public class NXBController {
    @Autowired
    NXBService nxbService;
    @GetMapping
    public List<NXBDTO> getNXBs() {
        return nxbService.getNXBs();
    }
}
