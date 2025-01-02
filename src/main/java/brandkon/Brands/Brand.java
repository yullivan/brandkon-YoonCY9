package brandkon.Brands;

import brandkon.categories.Category;
import jakarta.persistence.*;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;

    private String guidelines;

    @ManyToOne
    private Category category;

    public Brand() {
    }

    public Brand(String imageUrl,String name, Category category) {
        this.imageUrl = imageUrl;
        this.category = category;
        this.name = name;
    }

    public Brand(Long id, String name,  String guidelines) {
        this.id = id;
        this.name = name;
        this.guidelines = guidelines;
    }

    public String getGuidelines() {
        return guidelines;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }
}
