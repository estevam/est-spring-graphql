package ca.est.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.est.service.GraphQLService;
import graphql.ExecutionResult;
/**
 * @author Estevam Meneses
 * May 27, 2021
 */
@RestController
@RequestMapping("/graph")
public class BlogController {
	
	private static final Logger log = LoggerFactory.getLogger(BlogController.class);

	@Autowired
	private GraphQLService graphQLService;

	@PostMapping
	public ResponseEntity<Object> actionGraphQL(@RequestBody String query) {
		log.info("Entering: {}", query);
		ExecutionResult execute = graphQLService.initGraphQL().execute(query);
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}
}
