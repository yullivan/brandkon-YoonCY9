package brandkon.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByBrandId(Long brandId);
    List<Product> findTop5ByBrandIdOrderBySaleDesc(Long brandId);
    List<Product> findTop5ByCategoryIdOrderBySaleDesc(Long categoryId);

}

