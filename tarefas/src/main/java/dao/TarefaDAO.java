package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import util.HibernateUtil;
import vo.Tarefa;


public class TarefaDAO {
    EntityManager em;
    public TarefaDAO(){
        em = HibernateUtil.getEntityManager();
    }
    public void salvar(Tarefa tarefa){
        try{
        em.getTransaction().begin();
        em.persist(tarefa);
        em.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
   public List<Tarefa> getTodasTarefas(){
TypedQuery<Tarefa> query = 
        em.createNamedQuery("Tarefa.getTodasTarefas"
               , Tarefa.class);
return query.getResultList();
   } 
}
