package pl.sda.springtraining.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

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
        productService.addProduct(productName, stockAmount, url, price, productType);
        return "redirect:/products"; //przekierowanie na urla
    }

    @GetMapping(value = "/product/{id}")
    public String editProduct(Model model, @PathVariable Long id) {
        Optional<Product> productByID = productService.findProductByID(id);
        if (productByID.isPresent()) {
            model.addAttribute("productToEdit", productByID.get());
            model.addAttribute("productTypes", ProductType.values());
            return "editProduct";
        } else {
            throw new ProductNotFoundException("Nie znaleziono produktu o id "+id);
//            return "redirect:/admin/product";
        }
    }

    @PostMapping(value = "/product/{id}") //id nie jest niezbedne - sluzy nam jako fortel
    public String saveChanges(@ModelAttribute Product product, @PathVariable Long id) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @PostMapping(value = "/product/{id}/delete")
    public String deleteProduct(@PathVariable Long id){
        productService.removeProduct(id);
        return "redirect:/products";
    }
}
