package com.est;

import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author estevam
 */
@RestController("/person")
public class PersonController {

	@Autowired
	GraphQLService graphQLService;

	@PostMapping(value = "/query")
	public ResponseEntity<Object> allItems(@RequestBody String query) {
		ExecutionResult result = graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}
