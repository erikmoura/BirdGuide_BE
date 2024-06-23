package com.birdguide.Birdguide_BE.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.birdguide.Birdguide_BE.repository.BirdRepository;
import com.birdguide.Birdguide_BE.model.Bird;
import com.birdguide.Birdguide_BE.model.BirdResponse;

import java.util.List;

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

    public List<Bird> findByNomeContaining(String nome) {
        return repo.findByNomeContainingIgnoreCase(nome);
    }

    public List<Bird> findByNomeStartingWith(String inicial) {
        return repo.findByNomeStartingWithIgnoreCase(inicial);
    }

    public Bird getBirdById(Long id) {
        return repo.findById(id).orElse(null);
    }

    /*
    // metodo para criar ave
    public ResponseEntity<?> cadastrar(Bird ave){
        return new ResponseEntity<Bird>(repo.save(ave), HttpStatus.CREATED);
    }
    */
}
