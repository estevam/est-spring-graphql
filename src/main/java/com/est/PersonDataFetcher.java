package com.est;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * 
 * @author estevam
 *
 */
@Component
public class PersonDataFetcher implements DataFetcher<List<Person>>{
    
	@Autowired  
	private PersonRepository personRepository;

	@Override
	public List<Person> get(DataFetchingEnvironment arg0) {
		// TODO Auto-generated method stub
		return personRepository.getListPerson();
	}
}
