package ca.est.fetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.est.entity.User;
import ca.est.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * 
 * @author Estevam Meneses
 * May 27, 2021
 */
@Component
public class UserListFetcher implements DataFetcher<List<User>> {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> get(DataFetchingEnvironment environment) {
		return userRepository.findAll();
	}
}
