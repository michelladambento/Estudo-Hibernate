package br.com.vantec;

import br.com.vantec.model.Category;
import br.com.vantec.model.Product;
import br.com.vantec.model.dao.CategoryDAO;
import br.com.vantec.model.dao.ProductDAO;
import br.com.vantec.uils.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Category categorySaved = cadastrarCategoria();
        cadastrarProduto(categorySaved);
        EntityManager em = JPAUtil.getEntityManager();
        ProductDAO productDao = new ProductDAO(em);
        Product productFounded = productDao.findByIdProduct(1L);
        System.out.println(productFounded.getName());
        System.out.println("-----------------------");
        List<Product> producties = productDao.findAll();
        producties.forEach(p->System.out.println(p));
        System.out.println("-----------------------");
        List<Product> productiesFindbyNameCategory = productDao.findByNameCategory("Computer");
        System.out.println("Find by Category Name: ");
        productiesFindbyNameCategory.forEach(p-> System.out.println(p));
        System.out.println("Find Price from Product by productName:");
        System.out.println("R$: " + productDao.retrievePriceProductByProductName("DELL I550 I5"));
    }

    private static Category cadastrarCategoria(){
        EntityManager em = JPAUtil.getEntityManager();
        Category computer = new Category("Computer");
        CategoryDAO daoCategory = new CategoryDAO(em);
        em.getTransaction().begin();
        daoCategory.save(computer);
        em.getTransaction().commit();
        em.close();
        return computer;
    }

    private static void cadastrarProduto(Category categorySaved){
        EntityManager em = JPAUtil.getEntityManager();
        Product celular = new Product("DELL I550 I5", "Computadores I5 com 16GB RAM", BigDecimal.valueOf(5750.99), categorySaved);
        ProductDAO dao = new ProductDAO(em);
        em.getTransaction().begin();
        dao.save(celular);
        em.getTransaction().commit();
        em.close();
    }
}
