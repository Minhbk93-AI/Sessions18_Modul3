package comra.demo.repository.impl;

import comra.demo.model.entity.Category;
import comra.demo.repository.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    //Gate to interact into database
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        try {
            List list = session.createQuery("from Category").list();
            return list;
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean save(Category cate) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(cate);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
            session.close();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(Category cate) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(cate);
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(Integer cateId) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(getCategoryById(cateId));
            session.getTransaction().commit();
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public Category getCategoryById(Integer cateId) {
        Session session = sessionFactory.openSession();
        try{
            Category category = session.get(Category.class, cateId);
            return category;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<Category> findByName(String cateName) {
        if(cateName==null || !cateName.isEmpty()){
            cateName = "%";
        }else{
            cateName = "%"+cateName+"%";
        }

        Session session = sessionFactory.openSession();
        try{
            List list = session.createQuery("from Category where cateName like :cateName")
                    .setParameter("cateName",cateName)
                    .list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }
}
