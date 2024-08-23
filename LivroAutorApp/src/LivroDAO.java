import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LivroDAO {
    // Método para inserir um novo livro no banco de dados
    public void inserirLivro(Livro livro) throws SQLException {
        String sql = "INSERT INTO Livro (titulo, anoPublicacao, idAutor) VALUES (?, ?, ?)";
        try (Connection conn = ConexaoBD.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, livro.getTitulo());
            pstmt.setInt(2, livro.getAnoPublicacao());
            pstmt.setInt(3, livro.getIdAutor());
            pstmt.executeUpdate();
        }
    }

    // Método para listar todos os livros do banco de dados
    public void listarLivros() throws SQLException {
        String sql = "SELECT * FROM Livro";
        try (Connection conn = ConexaoBD.getInstance().getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("idLivro") +
                        ", Título: " + rs.getString("titulo") +
                        ", Ano: " + rs.getInt("anoPublicacao") +
                        ", ID Autor: " + rs.getInt("idAutor"));
            }
        }
    }
}
