package brandkon.product;

import brandkon.Brands.Brand;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    private int price;

    private String imageUrl;

    @ManyToOne
    private Brand brand;

    public Product(String productName, int price, String imageUrl, Brand brand) {
        this.productName = productName;
        this.price = price;
        this.imageUrl = imageUrl;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Brand getBrand() {
        return brand;
    }
}
