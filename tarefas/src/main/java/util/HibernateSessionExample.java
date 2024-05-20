package util;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package util;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import vo.Status;
import vo.Tarefa;

/**
 *
 * @author usuario
 */
public class HibernateSessionExample {

//    public static void main(String[] args) {
//        System.out.println("Conectando no banco...");
//
//        Transaction transaction = null;
//        try {
//            Session session = HibernateUtil.getSessionFactory().openSession();
//            // start a transaction
//            transaction = session.beginTransaction();
//            // save the book objects
//            session.persist(new Tarefa("xxxx", "asdasdsad", new Date()));
//
//            // commit transaction
//            transaction.commit();
//        } catch (Exception e) {
//            if (transaction != null) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//        }
//        System.out.println("Close");
//        System.exit(0);
//    }
//    public static void main(String[] args) {
//        EntityManager em = null;
//        try {
//            em = HibernateUtil.getEntityManagerPA();
//            em.getTransaction().begin();
//            em.persist(new Tarefa("1234", "1341241", new Date()));
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//            em.close();
//        } finally {
//            System.exit(0);
//        }
//    }
    public static void main(String[] args) {
        EntityManager em = null;
        try {
            em = HibernateUtil.getEntityManager();
            TypedQuery<Tarefa> query = em.createNamedQuery("Tarefa.findByStatus", Tarefa.class);
            query.setParameter("status", Status.PENDENTE);
            System.out.println(query.getResultList().size());
        } catch (Exception e) {
            e.printStackTrace();
            em.close();
        } finally {
            System.exit(0);
        }
    }
}
