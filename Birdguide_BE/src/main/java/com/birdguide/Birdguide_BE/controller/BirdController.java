package com.birdguide.Birdguide_BE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.birdguide.Birdguide_BE.service.BirdService;
import com.birdguide.Birdguide_BE.model.Bird;

@RestController
public class BirdController {

    @Autowired
    private BirdService servico;

    @GetMapping("/listar")
    public Iterable<Bird> listar(){
        return servico.listar();
    }



    @GetMapping("/")
    public String route(){
        return "test";
    }
}
