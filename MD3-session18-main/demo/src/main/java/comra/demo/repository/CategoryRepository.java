package comra.demo.repository;

import comra.demo.model.entity.Category;

import java.util.List;

public interface CategoryRepository {
    List<Category> findAll();
    boolean save(Category cate);
    boolean update(Category cate);
    boolean delete(Integer cateId);
    Category getCategoryById(Integer cateId);
    List<Category> findByName(String cateName);
}
