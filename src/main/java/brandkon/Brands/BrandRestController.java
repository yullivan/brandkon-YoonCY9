package brandkon.Brands;

import brandkon.Brands.DTO.BrandResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BrandRestController {

    private final BrandService brandService;

    public BrandRestController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/brands")
    // 특정 카테고리의 모든 브랜드 목록 전달
    public List<BrandResponse> findByBrand(@RequestParam(required = false, value = "category") String category) {
        return brandService.findByCategory(category);
    }

    @GetMapping("/brands/{brandId}")
    public BrandResponse findOne(@PathVariable Long brandId) {
        return brandService.findOne(brandId);
    }


}
