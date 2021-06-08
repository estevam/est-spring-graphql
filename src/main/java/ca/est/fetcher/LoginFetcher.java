package ca.est.fetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.est.entity.User;
import ca.est.repository.UserRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author Estevam Meneses
 * May 27, 2021
 */
@Component
public class LoginFetcher implements DataFetcher<User> {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User get(DataFetchingEnvironment env) {
		String username = env.getArgument("username");
		String password = env.getArgument("password");
		return userRepository.login(username, password);
	}
}
