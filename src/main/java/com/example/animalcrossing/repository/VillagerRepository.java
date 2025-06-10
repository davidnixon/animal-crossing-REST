package com.example.animalcrossing.repository;

import com.example.animalcrossing.model.Villager;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillagerRepository extends ListCrudRepository<Villager, Integer> {
}