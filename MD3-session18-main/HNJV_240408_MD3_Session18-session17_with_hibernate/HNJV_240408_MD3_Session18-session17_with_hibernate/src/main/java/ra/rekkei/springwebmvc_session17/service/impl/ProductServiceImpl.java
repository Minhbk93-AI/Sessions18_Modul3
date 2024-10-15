package ra.rekkei.springwebmvc_session17.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.rekkei.springwebmvc_session17.model.entity.Product;
import ra.rekkei.springwebmvc_session17.repository.ProductRepository;
import ra.rekkei.springwebmvc_session17.repository.impl.ProductRepositoryImpl;
import ra.rekkei.springwebmvc_session17.service.ProductService;

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
