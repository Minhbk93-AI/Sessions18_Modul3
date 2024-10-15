package comra.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer proId;
    @Column(name = "product_name",length = 100)
    private String proName;
    @Column(name = "producer",length = 100)
    private String producer;
    @Column(name = "year_making")
    private Integer yearMaking;
    @Column(name = "price")
    private Double price;
    @Column(name = "imageName")
    private String imageName;

    @ManyToOne
    @JoinColumn(name = "cate_id", referencedColumnName = "cate_Id")
    private Category cate;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> imageList;
}
