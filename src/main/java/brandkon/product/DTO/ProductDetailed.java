package brandkon.product.DTO;

import brandkon.Brands.DTO.BrandDetailsResponse;

public record ProductDetailed(int expirationDays, Long productId, String productName, int price,
                              BrandDetailsResponse brand) {
}
