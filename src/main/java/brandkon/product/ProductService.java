package brandkon.product;

import brandkon.Brands.Brand;
import brandkon.Brands.BrandRepository;
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
                p.getId(), p.getBrand().getName(), p.getProductName(),
                p.getPrice(), p.getImageUrl())).toList();
    }

    public List<ProductResponse> findOne(Long brandId) {
        List<Product> products = productRepository.findById(brandId).orElseThrow();
    }
}
