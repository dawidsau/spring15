package pl.sda.springtraining.products;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    List<Product> findProductsByType(ProductType productType);

    @Query("Select p " +
            "from Product p " +
            "where upper(p.productName) " +
            "like concat('%',upper(?1),'%')")
    List<Product> findProductsByProductNameLike(String searchText);

    @Query("Select p " +
            "from Product p " +
            "where upper(p.productName) " +
            "like concat('%',upper(?1),'%') " +
            "and p.type = ?2")
    List<Product> findProductsByProductNameLikeAndType(String searchText, ProductType productType);
}
