package com.github.maikoncanuto.mongoexample.graphql.resolvers;

import com.github.maikoncanuto.mongoexample.models.Autor;
import com.github.maikoncanuto.mongoexample.repositories.AutorMongoRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllAutorDataFetcher implements DataFetcher<List<Autor>> {

    @Autowired
    private AutorMongoRepository autorMongoRepository;

    @Override
    public List<Autor> get(DataFetchingEnvironment dataFetchingEnvironment) {
        return autorMongoRepository.findAll();
    }
}
