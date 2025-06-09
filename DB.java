import java.sql.*;

public class DB {
    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/diario?allowPublicKeyRetrieval=true&useSSL=false",
                    "root",
                    "lpk2540*db"
            );
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
        }
        return null;
    }
}
