package com.birdguide.Birdguide_BE.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.birdguide.Birdguide_BE.model.Bird;

@Repository
public interface BirdRepository extends CrudRepository<Bird, Long> {
}
