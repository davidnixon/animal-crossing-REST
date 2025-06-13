package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Fish;
import com.example.animalcrossing.repository.FishRepository;
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
@RequestMapping("/v2/fish")
@Tag(name = "Fish", description = "Operations related to Animal Crossing fish")
public class FishController {
    @Autowired
    FishRepository repository;

    @GetMapping
    @Operation(summary = "Get all the fish objects")
    public List<Fish> findAll() {
        return repository.findAll();
    }
}