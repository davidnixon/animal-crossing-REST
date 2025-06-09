package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.SeaCreature;
import com.example.animalcrossing.repository.SeaCreatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/v2/sea")
public class SeaCreatureController {
    @Autowired
    SeaCreatureRepository repository;

    @GetMapping
    public List<SeaCreature> findAll() {
        return repository.findAll();
    }
}