import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            AutorDAO autorDAO = new AutorDAO();
            Autor autor1 = new Autor("Autor 1", "Nacionalidade 1");
            Autor autor2 = new Autor("Autor 2", "Nacionalidade 2");
            autorDAO.inserirAutor(autor1);
            autorDAO.inserirAutor(autor2);
            System.out.println("Autores inseridos com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir autores: " + e.getMessage());
        }
    }
}
