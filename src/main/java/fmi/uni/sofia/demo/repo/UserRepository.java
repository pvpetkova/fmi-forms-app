package fmi.uni.sofia.demo.repo;

import fmi.uni.sofia.demo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    Iterable<User> findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}