package ca.est.fetcher;

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
public class UserFetcher implements DataFetcher<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User get(DataFetchingEnvironment env) {
		String id = env.getArgument("id");
		long idLong = Long.parseLong(id);
		return userRepository.findById(idLong).orElse(null);
	}

}
