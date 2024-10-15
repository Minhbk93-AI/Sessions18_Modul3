package ra.rekkei.springwebmvc_session17.repository;

import ra.rekkei.springwebmvc_session17.model.entity.Product;
import ra.rekkei.springwebmvc_session17.model.entity.ProductImage;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Integer proId);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Integer proId);
    List<Product> findByName(String proName);
}
