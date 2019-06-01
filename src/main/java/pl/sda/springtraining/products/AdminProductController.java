package pl.sda.springtraining.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequestMapping(value = "/admin")
public class AdminProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product")
    public String showForm(Model model) {
        model.addAttribute("productTypes", ProductType.values());
        return "addProduct";
    }
    @PostMapping(value = "/product")
    public String addProduct(@RequestParam String productName,
                             @RequestParam BigDecimal price,
                             @RequestParam String url,
                             @RequestParam Long stockAmount,
                             @RequestParam ProductType productType) {
        productService.addProduct(productName,stockAmount,url,price,productType);
    return "redirect:/products"; //przekierowanie na urla
    }
}
