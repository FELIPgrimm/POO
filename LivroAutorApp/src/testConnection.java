import java.sql.Connection;
import java.sql.SQLException;

public class testConnection {
    public static void main(String[] args) {
        try (Connection conn = ConexaoBD.getInstance().getConnection()) {
            if (conn != null && !conn.isClosed()) {
                System.out.println("Conexão com o banco de dados está aberta.");
            } else {
                System.out.println("Conexão com o banco de dados está fechada.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao testar a conexão: " + e.getMessage());
        }
    }
}
