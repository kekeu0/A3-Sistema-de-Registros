import java.sql.*;

public class UsuarioDB {
    public static int autenticar(String nome, String senha) throws SQLException {
        String sql = "SELECT id_usuarios, senha_hash FROM usuarios WHERE nome_usuario = ?";
        try (Connection conn = DB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String hash = rs.getString("senha_hash");
                if (hash.equals(Util.hashSenha(senha))) {
                    return rs.getInt("id_usuarios");
                }
            }
        }
        return -1;
    }

    public static boolean cadastrar(String nomeUsuario, String senha, String nomeCompleto, String email) throws SQLException {
        String sql = "INSERT INTO usuarios (nome_usuario, senha_hash, nome_completo, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DB.conectar(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nomeUsuario);
            stmt.setString(2, Util.hashSenha(senha));
            stmt.setString(3, nomeCompleto);
            stmt.setString(4, email);
            stmt.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            return false;
        }
    }
}
