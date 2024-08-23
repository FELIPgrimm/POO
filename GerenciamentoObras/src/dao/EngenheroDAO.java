package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperarioDAO {
    private Connection connection;

    public OperarioDAO() {
        connection = ConexaoBD.getConnection();
    }

    public void inserirOperario(Operario operario) throws SQLException {
        String sql = "INSERT INTO Operario (nome, funcao) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, operario.getNome());
            stmt.setString(2, operario.getFuncao());
            stmt.executeUpdate();
        }
    }

    public void atualizarOperario(Operario operario) throws SQLException {
        String sql = "UPDATE Operario SET nome = ?, funcao = ? WHERE idOperario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, operario.getNome());
            stmt.setString(2, operario.getFuncao());
            stmt.setInt(3, operario.getIdOperario());
            stmt.executeUpdate();
        }
    }

    public void excluirOperario(int idOperario) throws SQLException {
        String sql = "DELETE FROM Operario WHERE idOperario = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idOperario);
            stmt.executeUpdate();
        }
    }

    public List<Operario> listarOperarios() throws SQLException {
        List<Operario> operarios = new ArrayList<>();
        String sql = "SELECT * FROM Operario";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Operario operario = new Operario(
                        rs.getInt("idOperario"),
                        rs.getString("nome"),
                        rs.getString("funcao")
                );
                operarios.add(operario);
            }
        }
        return operarios;
    }
}
