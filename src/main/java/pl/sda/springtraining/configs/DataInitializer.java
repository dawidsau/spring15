package pl.sda.springtraining.configs;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.springtraining.roles.Role;
import pl.sda.springtraining.roles.RoleRepository;
import pl.sda.springtraining.users.User;
import pl.sda.springtraining.users.UserRepository;

@Component
public class DataInitializer implements InitializingBean {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (roleRepository.count() == 0) {
            Role role_user = roleRepository.save(new Role("ROLE_USER"));
            Role role_admin = roleRepository.save(new Role("ROLE_ADMIN"));
            User user = User.builder()
                    .username("admin")
                    .passwordHash(passwordEncoder.encode("admin"))
                    .roles(Sets.newHashSet(role_admin))
                    .build();
            userRepository.save(user);
            User normalUser = User.builder()
                    .username("user")
                    .passwordHash(passwordEncoder.encode("user"))
                    .roles(Sets.newHashSet(role_user))
                    .build();
            userRepository.save(normalUser);
        }
    }

}
