package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Fish;
import com.example.animalcrossing.repository.FishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/v2/fish")
public class FishController {
    @Autowired
    FishRepository repository;

    @GetMapping
    public List<Fish> findAll() {
        return repository.findAll();
    }
}
