package fmi.uni.sofia.demo.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    private Long userId;
    private String username;
    private String password;
    private String email;
}
