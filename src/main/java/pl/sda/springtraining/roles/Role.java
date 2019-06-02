package pl.sda.springtraining.roles;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.sda.springtraining.BaseEntity;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "ROLES")
public class Role extends BaseEntity {

    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
