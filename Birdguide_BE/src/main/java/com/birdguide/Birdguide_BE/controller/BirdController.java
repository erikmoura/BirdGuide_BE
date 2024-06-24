package com.birdguide.Birdguide_BE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.birdguide.Birdguide_BE.service.BirdService;
import com.birdguide.Birdguide_BE.model.Bird;

import java.util.List;

@RestController
@RequestMapping("/api/birds")
@CrossOrigin("http://localhost:5173")
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

    @GetMapping("/pesquisar")
    public List<Bird> pesquisar(@RequestParam String nome) {
        return servico.findByNomeContaining(nome);
    }

    @GetMapping("/inicial/{letra}")
    public List<Bird> listarPorInicial(@PathVariable String letra) {
        return servico.findByNomeStartingWith(letra);
    }

    @GetMapping("/{id}")
    public Bird getBirdById(@PathVariable Long id) {
        return servico.getBirdById(id);
    }

}
