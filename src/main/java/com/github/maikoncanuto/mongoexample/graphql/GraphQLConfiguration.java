package com.github.maikoncanuto.mongoexample.graphql;

import com.github.maikoncanuto.mongoexample.graphql.resolvers.AllAutorDataFetcher;
import com.github.maikoncanuto.mongoexample.graphql.resolvers.AutorDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Component
public class GraphQLConfiguration {

    @Value("classpath:models.graphqls")
    private Resource schema;

    @Autowired
    private AllAutorDataFetcher allAutorDataFetcher;

    @Autowired
    private AutorDataFetcher autorDataFetcher;

    @PostConstruct
    public GraphQL createGraphQLObject() throws IOException {
        File schemas = schema.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemas);
        RuntimeWiring wiring = RuntimeWiring
                .newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("autores", allAutorDataFetcher)
                        .dataFetcher("autor", autorDataFetcher))
                .build();

        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, wiring);
        return GraphQL.newGraphQL(schema).build();
    }
}
