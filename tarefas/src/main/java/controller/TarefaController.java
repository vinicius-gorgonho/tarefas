package controller;

import dao.TarefaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import vo.Tarefa;

@ViewScoped
@Named
public class TarefaController implements Serializable{
    Tarefa tarefaNova;
   ArrayList<Tarefa> lista;
   TarefaDAO dao;

   
    public ArrayList<Tarefa> getLista() {
        if(lista == null){
         dao = new TarefaDAO();
         lista = new ArrayList<>(dao.getTodasTarefas());
        }
        return lista;
    }
   
    public Tarefa getTarefaNova() {
        if(tarefaNova == null){
            tarefaNova = new Tarefa();
        }
        return tarefaNova;
    }

    public void setTarefaNova(Tarefa tarefaNova) {
        this.tarefaNova = tarefaNova;
    }
    
    public String index(){
        return "index";
    }
    public String listarTarefa(){
        return "listar_tarefa";
    }
    public String novaTarefa(){
        return "nova_tarefa";
    }
    
    public void salvar(){
  FacesMessage msg = new FacesMessage("xx", "xasdas");
FacesContext.getCurrentInstance().addMessage("xxx", msg);
    }
}
