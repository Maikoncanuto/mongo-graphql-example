package com.github.maikoncanuto.mongoexample.graphql.resolvers;

import com.github.maikoncanuto.mongoexample.models.Autor;
import com.github.maikoncanuto.mongoexample.repositories.AutorMongoRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AutorDataFetcher implements DataFetcher<Autor> {

    @Autowired
    private AutorMongoRepository autorMongoRepository;

    @Override
    public Autor get(DataFetchingEnvironment dataFetchingEnvironment) {
        Map<String, Object> arguments = dataFetchingEnvironment.getArguments();
        return autorMongoRepository.findById(String.valueOf(arguments.get("id"))).get();
    }
}
