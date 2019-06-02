package pl.sda.springtraining.configs;

import org.springframework.context.annotation.Profile;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("prod")
@RestController
@RequestMapping("/profile")
public class ProdProfileController {

    @RequestMapping
    public String prod() {
        return "PROD";
    }


    @Secured("ROLE_ADMIN") //do tej metody będzie miała dostęp osoba z rolą admina
    @RequestMapping("/adminOnly")
    public String adminOnly() {
        return "JESTEM ADMINEM";
    }

    @Secured("ROLE_USER")
    @RequestMapping("/userOnly")
    public String userOnly() {
        return "JESTEM USEREM";
    }

}
