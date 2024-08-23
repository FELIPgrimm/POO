package dao;

import model.Projeto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
    private Connection connection;

    public ProjetoDAO() {
        this.connection = ConexaoBD.getConnection();
    }

    public void inserirProjeto(Projeto projeto) throws SQLException {
        String sql = "INSERT INTO Projeto (nome, descricao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.executeUpdate();
        }
    }

    public void atualizarProjeto(Projeto projeto) throws SQLException {
        String sql = "UPDATE Projeto SET nome = ?, descricao = ? WHERE idProjeto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, projeto.getNome());
            stmt.setString(2, projeto.getDescricao());
            stmt.setInt(3, projeto.getIdProjeto());
            stmt.executeUpdate();
        }
    }

    public void excluirProjeto(int idProjeto) throws SQLException {
        String sql = "DELETE FROM Projeto WHERE idProjeto = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idProjeto);
            stmt.executeUpdate();
        }
    }

    // Métodos de atualizar, excluir e listar projetos
}
