package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Artwork;
import com.example.animalcrossing.repository.ArtworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/v2/art")
public class ArtworkController {
    @Autowired
    ArtworkRepository repository;

    @GetMapping
    public List<Artwork> findAll() {
        return repository.findAll();
    }
}
