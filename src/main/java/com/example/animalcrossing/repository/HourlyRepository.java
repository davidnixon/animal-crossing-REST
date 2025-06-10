package com.example.animalcrossing.repository;

import com.example.animalcrossing.model.Hourly;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HourlyRepository extends ListCrudRepository<Hourly, Integer> {
}