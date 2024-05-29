package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HibernateUtil {
    static EntityManagerFactory emf;
    
    public static EntityManager getEntityManager(){
 emf 
 = Persistence.createEntityManagerFactory("tarefas");
    EntityManager em = emf.createEntityManager();
    return em;
    }
}
