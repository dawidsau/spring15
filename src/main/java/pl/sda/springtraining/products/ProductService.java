package pl.sda.springtraining.products;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    void addProduct(String productName, Long stockAmount,
                    String url, BigDecimal price, ProductType type) {

        Product product = Product.builder()
                .productName(productName)
                .stockAmount(stockAmount)
                .price(price)
                .url(url)
                .type(type)
                .build();

        productRepository.save(product);
    }

    List<Product> findProducts(String searchText, ProductType searchProductType){ // todo tu nie powinny wychodzić encje -> DTO
        if (StringUtils.isBlank(searchText) && searchProductType == null) {
            return productRepository.findAll();
        }
        if (StringUtils.isBlank(searchText)) {
            return productRepository.findProductsByType(searchProductType);
        }
        if (searchProductType == null){
            return productRepository.findProductsByProductNameLike(searchText);
        }
        return productRepository.findProductsByProductNameLikeAndType(searchText, searchProductType);
    }
}
