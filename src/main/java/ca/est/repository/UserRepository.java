package ca.est.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ca.est.entity.User;
/**
 * 
 * @author Estevam Meneses 
 * May 25, 2021
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{

    @Query(value="SELECT * FROM user u WHERE u.username= :username AND u.password= :password ", nativeQuery=true)
    User login(String username, String password);
 
}
