package ra.rekkei.springwebmvc_session17.service;

import ra.rekkei.springwebmvc_session17.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(Integer proId);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Integer proId);
    List<Product> findByName(String proName);
}
