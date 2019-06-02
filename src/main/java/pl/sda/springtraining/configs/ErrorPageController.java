package pl.sda.springtraining.configs;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sda.springtraining.products.ProductNotFoundException;

@ControllerAdvice //controller służący do wyłapywania błędów w aplikacji - np by sie nie wypisywały brzydko klientowi
public class ErrorPageController {

//    @ExceptionHandler(value = ProductNotFoundException.class)
//    public String showErrorPageForNotFoundProduct(Exception ex, Model model) {
//        model.addAttribute("errorMessage", ex.getMessage());
//        return "errorPage";
//    }

    @ExceptionHandler(value = Exception.class)
    public String showErrorPage(Exception ex, Model model) {
        if (ex instanceof ProductNotFoundException) {
            model.addAttribute("errorMessage", ex.getMessage());
        } else {
            model.addAttribute("errorMessage", "Błąd: " + ex.getClass());
        }
        return "errorPage";
    }
}
