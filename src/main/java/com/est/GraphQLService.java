package com.est;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
 
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
 
/**
 * 
 * @author estevam
 *
 */
@Service
public class GraphQLService {
    @Value("classpath:person.graphql")
    Resource schemaResource;
 
    @Autowired
    private PersonDataFetcher personDataFetcher;
 

    private  GraphQL graphQL;
 
    @PostConstruct
    public void loadGraphQLSchema() throws IOException {
        File schema = schemaResource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schema);
        RuntimeWiring runtimeWiring = initWiring();
        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
 
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }
 
    private RuntimeWiring initWiring() {
 
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                .dataFetcher("allPerson", personDataFetcher)).build();
    }
 
    public GraphQL getGraphQL() {
        return graphQL;
    }
}
