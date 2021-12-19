package com.example.book.service.Impl;

import com.example.book.dto.NXBDTO;
import com.example.book.repository.NXBRepository;
import com.example.book.service.NXBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NXBServiceImpl implements NXBService {
    @Autowired
    NXBRepository nxbRepository;
    @Override
    public List<NXBDTO> getNXBs() {
        return nxbRepository.findAll().stream().map(NXBDTO::new)
                .collect(Collectors.toList());
    }
}
