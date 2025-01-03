package brandkon.brands;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Brand {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imageUrl;

    private String guidelines;

    @OneToMany(mappedBy = "brand")
    private List<BrandCategory> brandCategories;

    public Brand() {
    }

    public Brand(String imageUrl,String name) {
        this.imageUrl = imageUrl;
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


}
