package brandkon.product;

import brandkon.Brands.BrandRepository;
import brandkon.Brands.DTO.BrandDetailsResponse;
import brandkon.product.DTO.ProductDetailed;
import brandkon.product.DTO.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final BrandRepository brandRepository;

    public ProductService(ProductRepository productRepository, BrandRepository brandRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
    }

    public List<ProductResponse> findBrandAll(Long brandId) {
        List<Product> products = productRepository.findByBrandId(brandId);
        return products.stream().map(p -> new ProductResponse(
                p.getId(),
                p.getBrandName(),
                p.getName(),
                p.getPrice(),
                p.getImageUrl())).toList();
    }

    public ProductDetailed detailed(Long id) {
        Product product = productRepository.findById(id).orElseThrow();

        return new ProductDetailed(
                product.getExpirationDays(),
                product.getId(),
                product.getName(),
                product.getPrice(),
                new BrandDetailsResponse(product.getBrand().getId(), product.getBrandName(), product.getBrand().getGuidelines())
        );
    }

    public List<ProductResponse> BrandPopularProducts(Long brandId) {
        // 그냥 임의로 만든거 다시짜야함
        List<Product> products = productRepository.findTop5ByBrandIdOrderBySaleDesc(brandId);
        return products.stream().map(p -> new ProductResponse(p.getId(),
                p.getBrandName(),
                p.getName(),
                p.getPrice(),
                p.getImageUrl())).toList();
    }

    public List<ProductResponse> CategoryPopularProducts(Long ctId) {
        List<Product> products = productRepository.findTop5ByCategoryIdOrderBySaleDesc(ctId);
        return products.stream().map(p -> new ProductResponse(p.getId(),
                p.getBrandName(),
                p.getName(),
                p.getPrice(),
                p.getImageUrl())).toList();
    }
}
