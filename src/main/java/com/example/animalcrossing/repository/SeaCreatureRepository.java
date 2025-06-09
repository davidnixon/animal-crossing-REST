package com.example.animalcrossing.repository;

import com.example.animalcrossing.model.SeaCreature;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeaCreatureRepository extends ListCrudRepository<SeaCreature, Integer> {
}