package pl.sda.springtraining.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@Controller // z założenia do wyświetlania widoków
@RestController
@RequestMapping(value = "/api")
public class RestApiController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products")
//    @ResponseBody //mówi, że to będzie JSON
    public ResponseEntity<List<Product>> showAllProducts() {
        List<Product> products = productService.findProducts(null, null);


        return ResponseEntity.status(202).body(products);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> showProduct(@PathVariable Long id) {
        Optional<Product> productByID = productService.findProductByID(id);
        if (productByID.isPresent()) {
            return ResponseEntity.ok(productByID.get());
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        if (product.getId() == null) {
            productService.saveProduct(product);
            return ResponseEntity.status(201).body(product);
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @PutMapping(value = "/product")
    public ResponseEntity<Product> editProduct(@RequestBody Product product) {
        if (product.getId() != null) {
            productService.saveProduct(product);
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.unprocessableEntity().build();
    }
}
