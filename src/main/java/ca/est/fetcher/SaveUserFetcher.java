package ca.est.fetcher;

import java.util.UUID;

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
public class SaveUserFetcher implements DataFetcher<String> {

	@Autowired
	private UserRepository userRepository;
	@Override
	public String get(DataFetchingEnvironment env) {
		String username = env.getArgument("username");
		String password = env.getArgument("password");
		String role = env.getArgument("role");
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole(role);
		user.setToken(UUID.randomUUID().toString().replace("-", ""));
		userRepository.save(user);

		return "User saved.";
	}

}
