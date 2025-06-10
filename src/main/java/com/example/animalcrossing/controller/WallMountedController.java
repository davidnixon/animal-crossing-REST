package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Decor;
import com.example.animalcrossing.repository.DecorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/v2/wall-mounted")
public class WallMountedController {
    @Autowired
    DecorRepository repository;

    @GetMapping
    public List<Decor> findAll() {
        return repository.findByCategory("wall-mounted");
    }
}