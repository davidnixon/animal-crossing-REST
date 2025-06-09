package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Fossil;
import com.example.animalcrossing.repository.FossilsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/v2/fossils")
public class FossilController {
    @Autowired
    FossilsRepository repository;

    @GetMapping
    public List<Fossil> findAll() {
        return repository.findAll();
    }
}
