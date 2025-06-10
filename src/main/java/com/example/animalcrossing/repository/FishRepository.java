package com.example.animalcrossing.repository;

import com.example.animalcrossing.model.Fish;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishRepository extends ListCrudRepository<Fish, Integer> {
}
