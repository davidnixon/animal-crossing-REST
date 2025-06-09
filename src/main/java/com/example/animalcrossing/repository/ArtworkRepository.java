package com.example.animalcrossing.repository;

import com.example.animalcrossing.model.Artwork;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkRepository extends ListCrudRepository<Artwork, Integer> {
}
