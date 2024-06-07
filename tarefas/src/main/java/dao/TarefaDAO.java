package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.HibernateUtil;
import vo.Tarefa;

/**
 *
 * @author usuario
 */
public class TarefaDAO implements Serializable {

    EntityManager em;

    public TarefaDAO() {
        em = HibernateUtil.getEntityManager();
    }

    public List<Tarefa> getTarefas() {
        try {
            TypedQuery<Tarefa> query = em.createNamedQuery("Tarefa.findAll", Tarefa.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void salvar(Tarefa tarefa) {
        try {
            em.getTransaction().begin();
            em.persist(tarefa);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
