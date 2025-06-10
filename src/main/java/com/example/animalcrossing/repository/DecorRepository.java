package com.example.animalcrossing.repository;

import com.example.animalcrossing.model.Decor;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DecorRepository extends ListCrudRepository<Decor, Integer> {
    List<Decor> findByCategory(String category);
}