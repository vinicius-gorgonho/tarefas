/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.TarefaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import vo.Tarefa;

@Named
@ViewScoped
public class TarefaController implements Serializable {

    TarefaDAO dao;
    private Tarefa tarefaNova;
    private ArrayList<Tarefa> lista;

    public TarefaController() {
        tarefaNova = new Tarefa();
    }

    public Tarefa getTarefaNova() {
        return tarefaNova;
    }

    public void setTarefaNova(Tarefa tarefaNova) {
        this.tarefaNova = tarefaNova;
    }

    public String index() {
        return "index";
    }

    public String listarTarefa() {
        return "listar_tarefa";
    }

    public String novaTarefa() {
        return "nova_tarefa";
    }

    public String salvar() {
        FacesMessage msg;
        try {
            msg = new FacesMessage("Sucesso!", "Salvo com sucesso!");
            tarefaNova.setDataTarefa(new Date());
            dao = new TarefaDAO();
            dao.salvar(tarefaNova);
        } catch (Exception e) {
            msg = new FacesMessage("Erro!", "erro ao salvar tarefa!");
        }
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return "nova_tarefa";
    }

    public String nova() {
        tarefaNova = new Tarefa();
        return "nova_tarefa";
    }

    public ArrayList<Tarefa> getLista() {
        if (lista == null) {
            dao = new TarefaDAO();
            lista = new ArrayList<>(dao.getTarefas());
        }
        return lista;
    }

}
