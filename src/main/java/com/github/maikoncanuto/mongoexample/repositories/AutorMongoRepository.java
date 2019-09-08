package com.github.maikoncanuto.mongoexample.repositories;

import com.github.maikoncanuto.mongoexample.models.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorMongoRepository extends MongoRepository<Autor, String> {

}
