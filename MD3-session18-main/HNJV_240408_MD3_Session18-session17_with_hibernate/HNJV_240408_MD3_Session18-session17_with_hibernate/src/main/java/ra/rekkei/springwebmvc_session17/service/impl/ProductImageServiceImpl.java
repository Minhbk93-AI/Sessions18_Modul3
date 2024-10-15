package ra.rekkei.springwebmvc_session17.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.rekkei.springwebmvc_session17.model.entity.ProductImage;
import ra.rekkei.springwebmvc_session17.repository.ProductImageRepository;
import ra.rekkei.springwebmvc_session17.repository.impl.ProductImageRepositoryImpl;
import ra.rekkei.springwebmvc_session17.service.ProductImageService;

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
