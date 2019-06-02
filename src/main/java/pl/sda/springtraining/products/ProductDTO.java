package pl.sda.springtraining.products;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDTO {

    private Long id;
    private String productName;
    private Long stockAmount;
    private String url;
    private BigDecimal price;
    private ProductType type;
}
