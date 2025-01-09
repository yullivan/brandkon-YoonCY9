package brandkon.product;

import brandkon.Brands.Brand;
import brandkon.categories.Category;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private String imageUrl;

    private int expirationDays;

    private int sale;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Brand brand;

    public Product() {
    }

    public Product(String name, int price, String imageUrl, Brand brand, int expirationDays, int sale) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.expirationDays = expirationDays;
        this.sale = sale;
    }

    public int getExpirationDays() {
        return expirationDays;
    }

    public Category getCategory() {
        return category;
    }

    public int getSale() {
        return sale;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getBrandName() {
        return brand.getName();
    }

    public Brand getBrand() {
        return brand;
    }
}
