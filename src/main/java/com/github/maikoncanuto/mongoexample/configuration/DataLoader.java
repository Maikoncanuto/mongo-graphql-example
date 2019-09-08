package com.github.maikoncanuto.mongoexample.configuration;

import com.github.maikoncanuto.mongoexample.models.Artigo;
import com.github.maikoncanuto.mongoexample.models.Autor;
import com.github.maikoncanuto.mongoexample.repositories.AutorMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DataLoader {

    @Autowired
    private AutorMongoRepository autorMongoRepository;

    @PostConstruct
    private void gerarDados(){
        Autor autor = new Autor();
        autor.setNome("Maikon");

        Artigo artigo = new Artigo();
        artigo.setCorpo("Testando");
        artigo.setTitulo("Mongodb");

        autor.setArtigos(Arrays.asList(artigo));
        autorMongoRepository.save(autor);

        System.out.println("autor: " + autor);
    }

}
