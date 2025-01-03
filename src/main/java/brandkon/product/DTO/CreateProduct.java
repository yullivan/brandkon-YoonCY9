package brandkon.product.DTO;

import brandkon.brands.Brand;

public record CreateProduct(
                            String productName,
                            int price,
                            String imageUrl,
                            Brand brand) {
}
