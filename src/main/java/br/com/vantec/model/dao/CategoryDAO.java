package br.com.vantec.model.dao;

import br.com.vantec.model.Category;
import br.com.vantec.model.Product;

import javax.persistence.EntityManager;

public class CategoryDAO {

    private EntityManager em;

    public CategoryDAO(EntityManager em) {
        this.em = em;

    }

    public void save(Category category){
        em.persist(category);
    }

    public void update(Category category){
        em.merge(category);
    }

    public void delete(Category category){
        category = em.merge(category);
        em.remove(category);
    }

    public Category findByIdCategory(Long id){
        return em.find(Category.class, id);
    }

}
