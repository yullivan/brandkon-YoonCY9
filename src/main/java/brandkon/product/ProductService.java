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

    public List<ProductResponse> findAll () {
        List<Product> products = productRepository.findAll();
        return products.stream().map(p -> new ProductResponse(
                p.getId(), p.getBrandName(), p.getName(),
                p.getPrice(), p.getImageUrl())).toList();
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





}
