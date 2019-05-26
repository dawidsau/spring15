package pl.sda.springtraining;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

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
    private Set<Role> roles = new HashSet<>();

}
