import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static ConexaoBD instance;
    private Connection connection;

    private ConexaoBD() {
        try {
            // Certifique-se de que o caminho do banco de dados está correto
            connection = DriverManager.getConnection("jdbc:sqlite:livros_autores.db");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    public static synchronized ConexaoBD getInstance() {
        if (instance == null) {
            instance = new ConexaoBD();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao fechar a conexão: " + e.getMessage());
        }
    }
}
