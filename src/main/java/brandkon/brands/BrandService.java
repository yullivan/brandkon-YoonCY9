package brandkon.brands;

import brandkon.brands.DTO.BrandResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandCategoryRepo brandCategoryRepo;

    public BrandService(BrandRepository brandRepository, BrandCategoryRepo brandCategoryRepo) {
        this.brandRepository = brandRepository;
        this.brandCategoryRepo = brandCategoryRepo;
    }

    public List<BrandResponse> findAll() {
        List<Brand> brands = brandRepository.findAll();
        return brands.stream().map(b -> new BrandResponse(
                b.getId(), b.getName(), b.getImageUrl())).toList();
    }

    public List<BrandResponse> findByCategory(String slug) {
        List<BrandCategory> brands = brandCategoryRepo.findByCategorySlug(slug);
        return brands.stream().map(b -> new BrandResponse(
                b.getBrand().getId(),
                b.getBrand().getName(),
                b.getBrand().getImageUrl())).toList();
    }

    public BrandResponse findOne(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow();
        return new BrandResponse(brand.getId(), brand.getName(), brand.getImageUrl());
    }
}
