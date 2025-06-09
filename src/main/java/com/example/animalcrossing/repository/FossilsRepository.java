package com.example.animalcrossing.repository;

import com.example.animalcrossing.model.Fossil;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FossilsRepository extends ListCrudRepository<Fossil, Integer> {
}
