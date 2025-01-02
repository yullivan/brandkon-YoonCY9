package brandkon.product.DTO;

import brandkon.Brands.Brand;

public record CreateProduct(
                            String productName,
                            int price,
                            String imageUrl,
                            Brand brand) {
}
