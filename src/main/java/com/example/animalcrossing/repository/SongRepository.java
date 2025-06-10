package com.example.animalcrossing.repository;

import com.example.animalcrossing.model.Song;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends ListCrudRepository<Song, Integer> {
}