package brandkon.product;

import brandkon.product.DTO.ProductDetailed;
import brandkon.product.DTO.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestController {

    private final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponse> findBrandAll(@RequestParam(required = false, value = "brandId") Long brandId) {
        return productService.findBrandAll(brandId);
    }

    @GetMapping("/products/{productId}")
    // 상품 상세조회
    public ProductDetailed findDetailed(@PathVariable Long productId) {
        return productService.detailed(productId);
    }

    @GetMapping("/products/popular")
    // 인기상품
    public List<ProductResponse> popularProducts(@RequestParam(required = false, value = "brandId") Long brandId,
                                                 @RequestParam(required = false, value = "categoryId") Long categoryId) {
        if (brandId != null && categoryId == null) {
            return productService.BrandPopularProducts(brandId);
        } else if (brandId == null && categoryId != null) {
            return productService.CategoryPopularProducts(categoryId);
        }

        else {
            throw new IllegalArgumentException("브랜드아이디나 카테고리 아이디를 입력해주세요.");
        }
    }


}
