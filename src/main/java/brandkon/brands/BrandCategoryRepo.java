package brandkon.brands;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandCategoryRepo extends JpaRepository<BrandCategory, Long> {
    List<BrandCategory> findByCategorySlug(String slug);
}
