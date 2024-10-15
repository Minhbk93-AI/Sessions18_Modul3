package comra.demo.service.impl;

import comra.demo.model.entity.ProductImage;
import comra.demo.repository.ProductImageRepository;
import comra.demo.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageRepository productImageRepository;

    @Override
    public List<ProductImage> findAll() {
        return productImageRepository.findAll();
    }

    @Override
    public boolean save(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public boolean update(ProductImage productImage) {
        return productImageRepository.update(productImage);
    }

    @Override
    public boolean delete(Integer imageId) {
        return productImageRepository.delete(imageId);
    }

    @Override
    public boolean deleteByProId(Integer proId) {
        return productImageRepository.deleteByProId(proId);
    }
}
