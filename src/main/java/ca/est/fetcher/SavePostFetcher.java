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
public class SavePostFetcher implements DataFetcher<String> {

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public String get(DataFetchingEnvironment env) {
		
		//title: String, body: String, views: String, published: Int
		String title = env.getArgument("title");
		String body = env.getArgument("body");
		Integer views = env.getArgument("views");
		Integer published = env.getArgument("published");
		
		Post post = new Post();

		post.setTitle(title);
		post.setBody(body);
		post.setViews(views);
		post.setPublished(published);
		post.setUser_id(1);
		postRepository.save(post);
		return "Post saved.";
	}
}
