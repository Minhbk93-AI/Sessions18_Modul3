package comra.demo.service.impl;

import comra.demo.model.entity.Category;
import comra.demo.repository.CategoryRepository;
import comra.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.getCategoryById(id);
    }

    @Override
    public boolean save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public boolean update(Category category) {
        return categoryRepository.update(category);
    }

    @Override
    public boolean delete(Integer cateId) {
        return categoryRepository.delete(cateId);
    }

    @Override
    public List<Category> findByName(String cateName) {
        return categoryRepository.findByName(cateName);
    }
}
