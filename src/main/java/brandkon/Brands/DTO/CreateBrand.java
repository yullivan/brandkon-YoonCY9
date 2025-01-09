package brandkon.Brands.DTO;

import brandkon.categories.Category;

public record CreateBrand(String name, String imageUrl, Category category) {
}
