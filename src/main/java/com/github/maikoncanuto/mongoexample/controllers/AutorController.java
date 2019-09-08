package com.github.maikoncanuto.mongoexample.controllers;

import com.github.maikoncanuto.mongoexample.graphql.GraphQLConfiguration;
import graphql.ExecutionResult;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/query")
public class AutorController {

    private GraphQL graphQL;
    private final GraphQLConfiguration graphQLConfiguration;

    @Autowired
    public AutorController(GraphQLConfiguration graphQLConfiguration) throws IOException {
        this.graphQLConfiguration = graphQLConfiguration;
        graphQL = this.graphQLConfiguration.createGraphQLObject();
    }

    @PostMapping
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        System.out.println("errors: " + result.getErrors());
        return ResponseEntity.ok(result.getData());
    }
}
