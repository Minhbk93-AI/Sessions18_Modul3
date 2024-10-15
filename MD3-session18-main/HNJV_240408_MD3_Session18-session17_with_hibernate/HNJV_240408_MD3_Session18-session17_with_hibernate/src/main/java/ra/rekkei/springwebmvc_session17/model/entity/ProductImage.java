package ra.rekkei.springwebmvc_session17.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;
//    @Column(name = "product_id")
//    private Integer proId;
    @Column(name = "image_name")
    private String imageName;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    public ProductImage() {
    }

    public ProductImage(Integer imageId, String imageName, Product product) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.product = product;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
