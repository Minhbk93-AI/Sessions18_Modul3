package ra.rekkei.springwebmvc_session17.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer proId;
    @NotBlank(message = "Product name is empty!")
    @Column(name = "product_name")
    private String proName;
    @NotBlank(message = "Producer is empty!")
    @Column(name = "producer")
    private String producer;
    @NotNull(message = "Year making is empty!")
    @Column(name = "year_making")
    private Integer yearMaking;
    @NotNull(message = "Expire date is empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "Date is not valid")
    @Column(name = "expire_date")
    private Date expireDate;
    @NotNull(message = "Price is empty!")
    @Min(value = 0,message = "Price must be positive number")
    @Column(name = "price")
    private Double price;
    @NotBlank(message = "Unit price is empty!")
    @Column(name = "unit_price")
    private String unitPrice;
    @NotBlank(message = "Color is empty!")
    @Column(name = "color")
    private String color;
    @Column(name = "imageName")
    private String imageName;

    @OneToMany(mappedBy = "product")
    private List<ProductImage> imageList;

    public Product() {
    }

    public Product(Integer proId, String proName, String producer, Integer yearMaking, Date expireDate, Double price, String unitPrice, String color, String imageName) {
        this.proId = proId;
        this.proName = proName;
        this.producer = producer;
        this.yearMaking = yearMaking;
        this.expireDate = expireDate;
        this.price = price;
        this.unitPrice = unitPrice;
        this.color = color;
        this.imageName = imageName;
    }

    public List<ProductImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<ProductImage> imageList) {
        this.imageList = imageList;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Integer getYearMaking() {
        return yearMaking;
    }

    public void setYearMaking(Integer yearMaking) {
        this.yearMaking = yearMaking;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
