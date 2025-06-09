import javax.swing.*;
import java.awt.*;

public class LoginTela extends JFrame {
    private JTextField usuario;
    private JPasswordField senha;

    public LoginTela() {
        setTitle("Login Diário");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        usuario = new JTextField();
        senha = new JPasswordField();

        JButton butLogin = new JButton("Entrar");
        JButton butCadastrar = new JButton("Cadastrar");

        butLogin.addActionListener(e -> login());
        butCadastrar.addActionListener(e -> new CadastroTela());
        butLogin.setFont(new Font("Dialog", Font.BOLD, 15));

        setLayout(new GridLayout(4, 1));
        add(new JLabel("Usuário:"));
        add(usuario);
        add(new JLabel("Senha:"));
        add(senha);
        add(butLogin);
        add(butCadastrar);

        setVisible(true);
    }

    private void login() {
        try {
            int id = UsuarioDB.autenticar(usuario.getText(), new String(senha.getPassword()));
            if (id != -1) {
                dispose();
                new DiarioTela(id);
            } else {
                JOptionPane.showMessageDialog(this, "Login inválido");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
