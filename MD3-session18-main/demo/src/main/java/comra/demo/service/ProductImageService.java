package comra.demo.service;

import comra.demo.model.entity.ProductImage;

import java.util.List;

public interface ProductImageService {
    List<ProductImage> findAll();
    boolean save(ProductImage productImage);
    boolean update(ProductImage productImage);
    boolean delete(Integer imageId);
    boolean deleteByProId(Integer proId);
}
