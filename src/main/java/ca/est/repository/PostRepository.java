package ca.est.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ca.est.entity.Post;
/**
 * 
 * @author Estevam Meneses
 * May 25, 2021
 * 
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
