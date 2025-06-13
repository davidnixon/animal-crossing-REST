package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Song;
import com.example.animalcrossing.repository.SongRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/v2/songs")
@Tag(name = "Songs", description = "Operations related to Animal Crossing songs")
public class SongController {
    @Autowired
    SongRepository repository;

    @GetMapping
    @Operation(summary = "Get all the song objects")
    public List<Song> findAll() {
        return repository.findAll();
    }
}