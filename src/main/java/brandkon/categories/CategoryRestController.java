package brandkon.categories;

import brandkon.categories.DTO.CategoryResponse;
import brandkon.categories.DTO.CreateCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class CategoryRestController {

    private final CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public void Create(@RequestBody CreateCategory brands) {
        categoryService.Create(brands);
    }

    @GetMapping("/categories")
    public List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }
}
