package br.com.vantec.uils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("estudo-hibernate");

    public static EntityManager getEntityManager(){
        EntityManager em = FACTORY.createEntityManager();
        return em;





    }
}
 