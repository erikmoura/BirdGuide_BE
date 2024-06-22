package com.birdguide.Birdguide_BE.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.birdguide.Birdguide_BE.repository.BirdRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private BirdRepository repo;

    @Override
    public void run(String... args) throws Exception {

        // inicializando banco de dados de aves
        if(repo.count() == 0){
            repo.save(new Bird("Bem-te-vi", "Varios Estados", "Ave nativa do pais"));
            repo.save(new Bird("Águia careca", "estados unidos", "ave que é símbolo dos estados unidos"));
        }

    }
}
