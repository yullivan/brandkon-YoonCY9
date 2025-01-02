package brandkon.product.DTO;

import brandkon.Brands.Brand;

public record ProductResponse(Long id,
                              String brandName,
                              String productName,
                              int price,
                              String imageUrl) {
}
