/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TarefaDAO;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import vo.Status;
import vo.Tarefa;

/**
 *
 * @author usuario
 */
@Named
@SessionScoped
public class TarefaEditarController implements Serializable {

    @Inject
    TarefaDAO dao;

    @Inject
    private Tarefa tarefaEditar;

    public Tarefa getTarefaEditar() {
        return tarefaEditar;
    }

    public void setTarefaEditar(Tarefa tarefaEditar) {
        this.tarefaEditar = tarefaEditar;
    }

    public String iniciar_editar(Tarefa tarefa) {
        tarefaEditar = tarefa;
        return "editar";
    }

    public String editar() {
        FacesMessage msg;
        try {
            msg = new FacesMessage("Sucesso!", "Editado com sucesso!");

            dao = new TarefaDAO();
            dao.editar(tarefaEditar);
        } catch (Exception e) {
            msg = new FacesMessage("Erro!", "erro ao editar tarefa!");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "editar";
    }

    public Status[] getStatus() {
        return Status.values();
    }
}
