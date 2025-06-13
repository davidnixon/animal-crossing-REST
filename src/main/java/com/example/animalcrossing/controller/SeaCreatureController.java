package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.SeaCreature;
import com.example.animalcrossing.repository.SeaCreatureRepository;
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
@RequestMapping("/v2/sea")
@Tag(name = "Sea", description = "Operations related to Animal Crossing sea creatures")
public class SeaCreatureController {
    @Autowired
    SeaCreatureRepository repository;

    @GetMapping
    @Operation(summary = "Get all the sea creature objects")
    public List<SeaCreature> findAll() {
        return repository.findAll();
    }
}