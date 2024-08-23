package dao;

import model.Projeto;

public class Main {
    public static void main(String[] args) {
        ProjetoDAO projetoDAO = new ProjetoDAO();

        Projeto projeto = new Projeto(0, "Projeto A", "Construção de edifício");
        try {
            projetoDAO.inserirProjeto(projeto);
            System.out.println("Projeto inserido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

