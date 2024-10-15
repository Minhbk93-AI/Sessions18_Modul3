package comra.demo.service;

import comra.demo.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    boolean save(Category category);
    boolean update(Category category);
    boolean delete(Integer cateId);
    List<Category> findByName(String cateName);
}
