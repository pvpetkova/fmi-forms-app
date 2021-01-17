package fmi.uni.sofia.demo.repo;

import fmi.uni.sofia.demo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {

    Iterable<User> findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);

    // TODO: does not map as expected
    @Query("select count(distinct d.userKey) " +
            "from users u, surveys s, submitted d " +
            "where u.email = :email " +
            "  and u.userId = s.userId " +
            "  and s.surveyId = d.surveyId")

    public Integer findCount(@Param("email") String email);
}