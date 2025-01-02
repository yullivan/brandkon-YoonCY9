package brandkon.product;

import brandkon.product.DTO.ProductResponse;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }
    @GetMapping("/products")
    public ProductResponse findOne(@RequestParam Long brandId) {

    }
}
