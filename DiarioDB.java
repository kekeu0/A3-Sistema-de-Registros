import java.sql.*;
import java.util.*;

public class DiarioDB {
    public static void salvarEntrada(int idUsuario, String titulo, String texto) throws SQLException {
        String sql = "INSERT INTO registros (id_usuario, titulo, texto) VALUES (?, ?, ?)";
        try (Connection conn = DB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setString(2, titulo);
            stmt.setString(3, texto);
            stmt.executeUpdate();
        }
    }

    public static List<String> listarEntradas(int idUsuario) throws SQLException {
        List<String> entradas = new ArrayList<>();
        String sql = "SELECT data_entrada, titulo, texto FROM registros WHERE id_usuario = ? ORDER BY data_entrada DESC";
        try (Connection conn = DB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String entrada = "[ " + rs.getTimestamp("data_entrada") + " ]\n" +
                        "TÍTULO: " + rs.getString("titulo") + "\n\n" +
                        rs.getString("texto") + "\n\n----------------------\n\n";
                entradas.add(entrada);
            }
        }
        return entradas;
    }
}
