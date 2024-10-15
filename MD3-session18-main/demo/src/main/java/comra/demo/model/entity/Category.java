package comra.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @Column(name = "cate_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cateId;
    @Column(name = "cate_name",length = 100, nullable = false, unique = true)
    private String cateName;
    @Column(name = "status")
    private Boolean status;

    @OneToMany(mappedBy = "cate")
    private List<Product> products;
}
