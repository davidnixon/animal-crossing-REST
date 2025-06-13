package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Hourly;
import com.example.animalcrossing.repository.HourlyRepository;
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
@RequestMapping("/v2/hourly")
@Tag(name = "Hourly", description = "Operations related to Animal Crossing hourly weather report")
public class HourlyController {
    @Autowired
    HourlyRepository repository;

    @GetMapping
    @Operation(summary = "Get all the hourly weather report objects")
    public List<Hourly> findAll() {
        return repository.findAll();
    }
}