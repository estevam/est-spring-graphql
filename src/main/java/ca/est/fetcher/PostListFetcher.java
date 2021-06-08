package ca.est.fetcher;

import java.util.List;

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
public class PostListFetcher implements DataFetcher<List<Post>> {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> get(DataFetchingEnvironment environment) {
		return postRepository.findAll();
	}
}
