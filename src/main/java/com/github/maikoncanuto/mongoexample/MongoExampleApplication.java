package com.github.maikoncanuto.mongoexample;

import com.github.maikoncanuto.mongoexample.models.Autor;
import com.github.maikoncanuto.mongoexample.repositories.AutorMongoRepository;
import com.mongodb.client.MongoClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class MongoExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoExampleApplication.class, args);
    }
}
