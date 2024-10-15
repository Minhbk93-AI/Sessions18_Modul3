package comra.demo.repository;

import comra.demo.model.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Integer proId);
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Integer proId);
    List<Product> findByName(String proName);
}
