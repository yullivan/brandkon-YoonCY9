package brandkon.categories;

import brandkon.categories.DTO.CategoryResponse;
import brandkon.categories.DTO.CreateCategory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void Create(CreateCategory dto) {
        Category category = new Category(dto.name(), dto.slug(), dto.imageUrl());
        categoryRepository.save(category);
    }

    public List<CategoryResponse> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().
                map(c -> new CategoryResponse(c.getId(), c.getName(), c.getSlug(), c.getImageUrl()
                        )
                ).toList();
    }
}
