package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Hourly;
import com.example.animalcrossing.repository.HourlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@RequestMapping("/v2/hourly")
public class HourlyController {
    @Autowired
    HourlyRepository repository;

    @GetMapping
    public List<Hourly> findAll() {
        return repository.findAll();
    }
}