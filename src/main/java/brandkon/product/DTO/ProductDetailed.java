package brandkon.product.DTO;

import brandkon.brands.DTO.BrandDetailsResponse;

public record ProductDetailed(int expirationDays, Long productId, String productName, int price,
                              BrandDetailsResponse brand) {
}
