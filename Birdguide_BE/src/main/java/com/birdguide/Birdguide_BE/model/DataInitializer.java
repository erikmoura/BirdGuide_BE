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
            repo.save(new Bird("Bem-te-vi", "América Latina, América Central", "Sua plumagem é predominantemente amarela com a cabeça, asas e cauda pretas.", "https://www.passaro.org/wp-content/uploads/2018/10/bem-te-vi.jpg"));
            repo.save(new Bird("Curió", "Do Nordeste até o Sul do Brasil", "O nome possui origem indígena (tupi-guarani), e ao ser traduzido para o português significa “amigo do homem”.", "https://s3.amazonaws.com/media.wikiaves.com.br/images/4091/1904857g_6d232cf89582f7333758e5aaf690f42b.jpg"));
            repo.save(new Bird("Rasga-Mortalha", "Nordeste do Brasil", "\"O povo do interior tem pavor de seu grito agourento, tido como aviso de que alguém vai morrer\"", "https://2.bp.blogspot.com/-eZoMR2s4yM0/V8gx6e5YWcI/AAAAAAAAD-0/Thnpd7OsHv03r7XftTVucxK32-0flSTpQCLcB/s1600/000001.jpg"));
        }

    }
}
