package br.com.vantec.model.dao;

import br.com.vantec.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDAO {

    private EntityManager em;

    public ProductDAO(EntityManager em) {
        this.em = em;

    }

    public void save(Product product){
        em.persist(product);
    }

    public void update(Product product){
        em.merge(product);
    }

    public void delete(Product product){
        product = em.merge(product);
        em.remove(product);
    }

    public Product findByIdProduct(Long id){
        return em.find(Product.class, id);
    }

    public List<Product> findAll(){
        //JPQL JAVA PERSISTENCE QUERY LANGUAGE
        String jpql = "SELECT p FROM Product p";
        return em.createQuery(jpql, Product.class).getResultList();
    }

    public List<Product> findByNameProduct(String name){
        String jpql = "SELECT p FROM Product p WHERE p.name = :nameProduct";
        return em.createQuery(jpql, Product.class)
                .setParameter("nameProduct", name)
                .getResultList();
    }

    public List<Product> findByNameCategory(String name){
        String jpql = "SELECT p FROM Product p WHERE p.category.name = :nameCategory";
        return em.createQuery(jpql, Product.class)
                .setParameter("nameCategory", name)
                .getResultList();
    }

    public BigDecimal retrievePriceProductByProductName(String name){
        String jpql = "SELECT p.price FROM Product p WHERE p.name = :nameProduct";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nameProduct", name)
                .getSingleResult();
    }

}
