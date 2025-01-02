package brandkon.Brands;

import brandkon.Brands.DTO.BrandResponse;
import brandkon.Brands.DTO.CreateBrand;
import brandkon.categories.Category;
import brandkon.categories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public BrandService(BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    public void Create(Long id, CreateBrand dto) {
        Category category = categoryRepository.findById(id).orElseThrow();
        Brand brand =
                new Brand(dto.imageUrl(), dto.name(), category);
        brandRepository.save(brand);
    }

//    public List<BrandResponse> findAll() {
//        List<Brand> brands = brandRepository.findAll();
//        return brands.stream().map(b -> new BrandResponse(
//                b.getId(),b.getName(),b.getImageUrl())).toList();
//    }

    public List<BrandResponse> findByCategory(String slug) {
        List<Brand> brands = brandRepository.findByCategorySlug(slug);
        return brands.stream().map(b -> new BrandResponse(b.getId(), b.getName(), b.getImageUrl())).toList();
    }

    public BrandResponse findOne(Long brandId) {
        Brand brand = brandRepository.findById(brandId).orElseThrow();
        return new BrandResponse(brand.getId(),brand.getName(), brand.getImageUrl());
    }
}
