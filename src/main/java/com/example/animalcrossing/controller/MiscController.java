package com.example.animalcrossing.controller;

import com.example.animalcrossing.model.Decor;
import com.example.animalcrossing.repository.DecorRepository;
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
@RequestMapping("/v2/misc")
@Tag(name = "Misc", description = "Operations related to Animal Crossing miscellaneous decor")
public class MiscController {
    @Autowired
    DecorRepository repository;

    @GetMapping
    @Operation(summary = "Get all the miscellaneous decor objects")
    public List<Decor> findAll() {
        return repository.findByCategory("misc");
    }
}