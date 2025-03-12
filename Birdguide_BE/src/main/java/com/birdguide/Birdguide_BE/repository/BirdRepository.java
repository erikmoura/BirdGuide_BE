package com.birdguide.Birdguide_BE.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.birdguide.Birdguide_BE.model.Bird;

import java.util.List;

@Repository
public interface BirdRepository extends CrudRepository<Bird, Long> {
    List<Bird> findByNomeContainingIgnoreCase(String nome);
    List<Bird> findByNomeStartingWithIgnoreCase(String inicial);
}
