package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Bug;
import com.example.animalcrossing.repository.BugRepository;
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
@RequestMapping("/v2/bugs")
@Tag(name = "Bugs", description = "Operations related to Animal Crossing bugs")
public class BugController {
    @Autowired
    BugRepository repository;

    @GetMapping
    @Operation(summary = "Get all the bug objects")
    public List<Bug> findAll() {
        return repository.findAll();
    }
}