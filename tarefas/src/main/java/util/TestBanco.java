package util;

import dao.TarefaDAO;
import vo.Tarefa;

public class TestBanco {
    public static void main(String[] args) {
       TarefaDAO dao = new TarefaDAO();
       Tarefa tarefa = new Tarefa();
       tarefa.setTitulo("Nova Tarefa");
       dao.salvar(tarefa);
    }
    
}
