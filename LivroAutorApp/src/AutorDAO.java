import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AutorDAO {
    public void inserirAutor(Autor autor) throws SQLException {
        String sql = "INSERT INTO Autor (nome, nacionalidade) VALUES (?, ?)";
        try (Connection conn = ConexaoBD.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            System.out.println("Conexão aberta: " + (conn != null && !conn.isClosed()));
            pstmt.setString(1, autor.getNome());
            pstmt.setString(2, autor.getNacionalidade());
            pstmt.executeUpdate();
        }
    }


    public void listarAutores() throws SQLException {
        String sql = "SELECT * FROM Autor";
        try (Connection conn = ConexaoBD.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (conn == null || conn.isClosed()) {
                throw new SQLException("A conexão com o banco de dados não está aberta.");
            }
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idAutor") +
                        ", Nome: " + rs.getString("nome") +
                        ", Nacionalidade: " + rs.getString("nacionalidade"));
            }
        }
    }
}
