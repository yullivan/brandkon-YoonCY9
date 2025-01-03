package brandkon.brands;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Long> {
//    List<Brand> findByCategorySlug(String slug);
}
