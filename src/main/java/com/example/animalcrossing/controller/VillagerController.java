package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Villager;
import com.example.animalcrossing.repository.VillagerRepository;
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
@RequestMapping("/v2/villagers")
@Tag(name = "Villagers", description = "Operations related to Animal Crossing villagers")
public class VillagerController {
    @Autowired
    VillagerRepository repository;

    @GetMapping
    @Operation(summary = "Get all the villager objects")
    public List<Villager> findAll() {
        return repository.findAll();
    }
}