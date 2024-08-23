package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipamentoDAO {
    private Connection connection;

    public EquipamentoDAO() {
        connection = ConexaoBD.getConnection();
    }

    public void inserirEquipamento(Equipamento equipamento) throws SQLException {
        String sql = "INSERT INTO Equipamento (nome, tipo) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getTipo());
            stmt.executeUpdate();
        }
    }

    public void atualizarEquipamento(Equipamento equipamento) throws SQLException {
        String sql = "UPDATE Equipamento SET nome = ?, tipo = ? WHERE idEquipamento = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, equipamento.getNome());
            stmt.setString(2, equipamento.getTipo());
            stmt.setInt(3, equipamento.getIdEquipamento());
            stmt.executeUpdate();
        }
    }

    public void excluirEquipamento(int idEquipamento) throws SQLException {
        String sql = "DELETE FROM Equipamento WHERE idEquipamento = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idEquipamento);
            stmt.executeUpdate();
        }
    }

    public List<Equipamento> listarEquipamentos() throws SQLException {
        List<Equipamento> equipamentos = new ArrayList<>();
        String sql = "SELECT * FROM Equipamento";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipamento equipamento = new Equipamento(
                        rs.getInt("idEquipamento"),
                        rs.getString("nome"),
                        rs.getString("tipo")
                );
                equipamentos.add(equipamento);
            }
        }
        return equipamentos;
    }
}
