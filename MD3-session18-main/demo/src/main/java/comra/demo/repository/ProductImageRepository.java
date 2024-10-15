package comra.demo.repository;

import comra.demo.model.entity.ProductImage;

import java.util.List;

public interface ProductImageRepository {
    List<ProductImage> findAll();
    boolean save(ProductImage productImage);
    boolean update(ProductImage productImage);
    boolean delete(Integer imageId);
    boolean deleteByProId(Integer proId);
}
