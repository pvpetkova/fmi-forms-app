package fmi.uni.sofia.demo.endpoints;

import fmi.uni.sofia.demo.model.User;
import fmi.uni.sofia.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/users")
public class UsersEndpoint {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/login")
    public @ResponseStatus
    HttpStatus login(@RequestParam String name, @RequestParam String password) {
        // check if user exists and credentials are correct
        if (userRepository.findByUsernameAndPassword(name, password).iterator().hasNext()) {
            return HttpStatus.OK;
        } else {
            return HttpStatus.UNAUTHORIZED;
        }
    }

    @PostMapping(path = "/register")
    public @ResponseBody
    Long addNewUser(@RequestBody User user) {
        User n = new User();
        n.setUsername(user.getUsername());
        n.setEmail(user.getEmail());
        n.setPassword(user.getPassword());

        User insertedEntity = userRepository.save(n);
        return insertedEntity.getUserId();
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

}
