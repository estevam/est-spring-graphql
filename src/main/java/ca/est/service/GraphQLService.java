package ca.est.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import ca.est.fetcher.LoginFetcher;
import ca.est.fetcher.PostFetcher;
import ca.est.fetcher.PostListFetcher;
import ca.est.fetcher.SavePostFetcher;
import ca.est.fetcher.SaveUserFetcher;
import ca.est.fetcher.UserFetcher;
import ca.est.fetcher.UserListFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

/**
 * 
 * @author Estevam Meneses 
 * May 25, 2021
 * 
 * GraphQLService.class wil provide service for User & Post.
 */
@Service
public class GraphQLService {

	private GraphQL graphQL;

	@Autowired
	private UserFetcher userFetcher;

	@Autowired
	private UserListFetcher userListFetcher;

	@Autowired
	private PostFetcher postFetcher;

	@Autowired
	private PostListFetcher postListFetcher;
	
	@Autowired
	private LoginFetcher loginFetcher;

	@Autowired
	private SaveUserFetcher saveUserFetcher;
	
	@Autowired
	private SavePostFetcher savePostFetcher;

	@Value("schema.graphql")
	private ClassPathResource classPath;

	@PostConstruct
	private void loadSchema() throws IOException {
		InputStream st = classPath.getInputStream();
		Reader targetReader = new InputStreamReader(st);
		TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(targetReader);
		RuntimeWiring runtimeWiring = buildRuntimeWiring();
		GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
		graphQL = GraphQL.newGraphQL(graphQLSchema).build();
	}

	/**
	 * Implement DTO ?!?
	 * @return
	 */
	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query",
						typeWiring -> typeWiring
						.dataFetcher("saveUser", saveUserFetcher)
						.dataFetcher("savePost", savePostFetcher)
						
						.dataFetcher("user", userFetcher)
						.dataFetcher("allUser", userListFetcher)
								
						.dataFetcher("post", postFetcher)
					    .dataFetcher("allPost", postListFetcher)
								
						.dataFetcher("login", loginFetcher))
				.build();
	}

	/**
	 * GraphQL is initialized on loadSchema() witch is loaded on project start
	 * 
	 * @return
	 */
	public GraphQL initGraphQL() {
		return graphQL;
	}
}
