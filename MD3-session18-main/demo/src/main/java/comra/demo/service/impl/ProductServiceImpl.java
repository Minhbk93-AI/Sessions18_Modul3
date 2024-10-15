package comra.demo.service.impl;

import comra.demo.model.entity.Product;
import comra.demo.repository.ProductRepository;
import comra.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer proId) {
        return productRepository.findById(proId);
    }

    @Override
    public boolean save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(Integer proId) {
        return productRepository.delete(proId);
    }

    @Override
    public List<Product> findByName(String proName) {
        return productRepository.findByName(proName);
    }
}
