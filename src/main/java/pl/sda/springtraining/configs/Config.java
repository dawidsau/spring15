package pl.sda.springtraining.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

    @Bean
    public PasswordEncoder passwordEncoder() { //fixme
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence + ".";
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return (charSequence+".").equals(s);
            }
        };
    }
}
