package comra.demo.repository.impl;

import comra.demo.model.entity.ProductImage;
import comra.demo.repository.ProductImageRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductImageRepositoryImpl implements ProductImageRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ProductImage> findAll() {
        Session session = sessionFactory.openSession();
        try{
            List list = session.createQuery("from ProductImage").list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean save(ProductImage productImage) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(productImage);
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
    public boolean update(ProductImage productImage) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(productImage);
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
    public boolean delete(Integer imageId) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            int i = session.createQuery("delete from ProductImage where imageId = :imageId")
                    .setParameter("imageId", imageId)
                    .executeUpdate();
            session.getTransaction().commit();
            if(i>0)
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
    public boolean deleteByProId(Integer proId) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            int i = session.createQuery("delete from ProductImage where Product.proId = :proId")
                    .setParameter("proId", proId)
                    .executeUpdate();
            session.getTransaction().commit();
            if(i>0)
                return true;
        }catch (Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }
}
