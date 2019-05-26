package pl.sda.springtraining.users;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import pl.sda.springtraining.roles.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String firstName;
    private String lastName;
    @Embedded
    private UserAddress userAddress;
    private String birthDate;
    private String pesel;
    private String username;
    private String passwordHash;
    private String phone;
    private boolean preferEmails;
    @ManyToMany
    @JoinTable(name = "users_roles")
    private Set<Role> roles = new HashSet<>();

}
