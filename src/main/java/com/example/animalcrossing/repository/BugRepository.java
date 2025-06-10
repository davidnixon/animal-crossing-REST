package com.example.animalcrossing.repository;

import com.example.animalcrossing.model.Bug;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends ListCrudRepository<Bug, Integer> {
}
