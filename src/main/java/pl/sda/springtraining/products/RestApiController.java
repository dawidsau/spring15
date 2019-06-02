package pl.sda.springtraining.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // z założenia do wyświetlania widoków
@RestController
@RequestMapping(value = "/api")
public class RestApiController {

    @Autowired
    private ProductService productService;

    @GetMapping
//    @ResponseBody //mówi, że to będzie JSON
    public ResponseEntity<List<Product>> showAllProducts(){
        List<Product> products = productService.findProducts(null, null);


        return ResponseEntity.status(202).body(products);
    }
}
