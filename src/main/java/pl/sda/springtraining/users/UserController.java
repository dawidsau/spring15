package pl.sda.springtraining.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping(value = "/register")
    public String showForm(Model model){
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        model.addAttribute("userDto", userRegistrationDTO);
        model.addAttribute("countries", Countries.values());
        return "registerForm";
    }

    @PostMapping(value="/register")
    public String register(@ModelAttribute(name = "userDto") @Valid UserRegistrationDTO userDto,
                           BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("countries", Countries.values());
            return "registerForm";
        }
        userRegistrationService.registerUser(userDto);
        return "index";
    }
}