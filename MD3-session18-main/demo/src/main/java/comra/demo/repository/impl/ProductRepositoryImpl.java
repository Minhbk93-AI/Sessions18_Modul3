package comra.demo.repository.impl;

import comra.demo.model.entity.Product;
import comra.demo.repository.ProductRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> findAll() {
        Session session = sessionFactory.openSession();
        try{
            List list = session.createQuery("from Product ").list();
            return list;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public Product findById(Integer proId) {
        Session session = sessionFactory.openSession();
        try{
            Product product = session.get(Product.class, proId);
            return product;
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    }

    @Override
    public boolean save(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.save(product);
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
    public boolean update(Product product) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.update(product);
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
    public boolean delete(Integer proId) {
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();
            session.delete(findById(proId));
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
    public List<Product> findByName(String proName) {
        if(proName==null || !proName.isEmpty()){
            proName = "%";
        }else{
            proName = "%"+proName+"%";
        }

        Session session = sessionFactory.openSession();
        try{
            List list = session.createQuery("from Product where proName like :proName")
                    .setParameter("proName",proName)
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
