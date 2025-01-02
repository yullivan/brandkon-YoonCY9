package brandkon.product;

import brandkon.Brands.Brand;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int price;

    private String imageUrl;

    private int expirationDays;

    @ManyToOne
    private Brand brand;

    public Product() {
    }

    public Product(String name, int price, String imageUrl, Brand brand, int expirationDays) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.brand = brand;
        this.expirationDays = expirationDays;
    }

    public int getExpirationDays() {
        return expirationDays;
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
