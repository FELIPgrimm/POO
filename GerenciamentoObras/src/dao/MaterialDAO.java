package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaterialDAO {
    private Connection connection;

    public MaterialDAO() {
        connection = ConexaoBD.getConnection();
    }

    public void inserirMaterial(Material material) throws SQLException {
        String sql = "INSERT INTO Material (nome, quantidade) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, material.getNome());
            stmt.setInt(2, material.getQuantidade());
            stmt.executeUpdate();
        }
    }

    public void atualizarMaterial(Material material) throws SQLException {
        String sql = "UPDATE Material SET nome = ?, quantidade = ? WHERE idMaterial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, material.getNome());
            stmt.setInt(2, material.getQuantidade());
            stmt.setInt(3, material.getIdMaterial());
            stmt.executeUpdate();
        }
    }

    public void excluirMaterial(int idMaterial) throws SQLException {
        String sql = "DELETE FROM Material WHERE idMaterial = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idMaterial);
            stmt.executeUpdate();
        }
    }

    public List<Material> listarMateriais() throws SQLException {
        List<Material> materiais = new ArrayList
