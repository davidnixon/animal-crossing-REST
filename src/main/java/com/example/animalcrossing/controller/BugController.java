package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Bug;
import com.example.animalcrossing.repository.BugRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/v2/bugs")
public class BugController {
    @Autowired
    BugRepository repository;

    @GetMapping
    public List<Bug> findAll() {
        return repository.findAll();
    }
}
