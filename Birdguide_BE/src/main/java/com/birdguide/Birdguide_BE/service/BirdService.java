package com.birdguide.Birdguide_BE.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.birdguide.Birdguide_BE.repository.BirdRepository;
import com.birdguide.Birdguide_BE.model.Bird;
import com.birdguide.Birdguide_BE.model.BirdResponse;

@Service
public class BirdService {

    @Autowired
    private BirdRepository repo;

    @Autowired
    private BirdResponse response;

    // metodo para listar todas as aves
    public Iterable<Bird> listar(){
        return repo.findAll();
    }

    /*
    // metodo para criar ave
    public ResponseEntity<?> cadastrar(Bird ave){
        return new ResponseEntity<Bird>(repo.save(ave), HttpStatus.CREATED);
    }
    */
}
