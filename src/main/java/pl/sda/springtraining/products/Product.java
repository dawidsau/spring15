package pl.sda.springtraining.products;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "products")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String productName;
    private Long stockAmount;
    private String url;
    private BigDecimal price;
    private ProductType type;
}
