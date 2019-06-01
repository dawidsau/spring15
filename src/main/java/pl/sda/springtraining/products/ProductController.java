package pl.sda.springtraining.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
    public String showProducts(Model model,
                               @RequestParam(required = false) String searchText,
                               @RequestParam(required = false) ProductType searchProductType){
        model.addAttribute("productsList", productService.findProducts(searchText, searchProductType));
        model.addAttribute("productTypes", ProductType.values());
        model.addAttribute("returnedSearchText", searchText);
        model.addAttribute("returnedType",searchProductType);
        return "productsView";
    }
}
