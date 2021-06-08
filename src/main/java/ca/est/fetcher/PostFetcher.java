package ca.est.fetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ca.est.entity.Post;
import ca.est.repository.PostRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

/**
 * @author Estevam Meneses
 * May 27, 2021
 */
@Component
public class PostFetcher implements DataFetcher<Post> {

	@Autowired
	private PostRepository postRepository;

	@Override
	public Post get(DataFetchingEnvironment env) {
		String id = env.getArgument("id");
		long idLong = Long.parseLong(id);
		return postRepository.findById(idLong).orElse(null);
	}
}
