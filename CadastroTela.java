import javax.swing.*;
import java.awt.*;

public class CadastroTela extends JFrame {
    private JTextField nomeCompleto, nomeUsuario, email;
    private JPasswordField senha, confirmarSenha;

    public CadastroTela() {
        setTitle("Cadastro de Usuário");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        nomeCompleto = new JTextField();
        nomeUsuario = new JTextField();
        email = new JTextField();
        senha = new JPasswordField();
        confirmarSenha = new JPasswordField();

        JButton butCadastrar = new JButton("Cadastrar");
        butCadastrar.addActionListener(e -> cadastrar());

        setLayout(new GridLayout(6, 2));
        add(new JLabel("Nome completo:"));
        add(nomeCompleto);
        add(new JLabel("Nome de usuário:"));
        add(nomeUsuario);
        add(new JLabel("Email:"));
        add(email);
        add(new JLabel("Senha:"));
        add(senha);
        add(new JLabel("Confirmar senha:"));
        add(confirmarSenha);
        add(new JLabel());
        add(butCadastrar);

        setVisible(true);
    }

    private void cadastrar() {
        String nome = nomeCompleto.getText().trim();
        String usuario = nomeUsuario.getText().trim();
        String mail = email.getText().trim();
        String senhaTexto = new String(senha.getPassword());
        String confirmarTexto = new String(confirmarSenha.getPassword());

        if (nome.isEmpty() || usuario.isEmpty() || mail.isEmpty() || senhaTexto.isEmpty() || confirmarTexto.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos os campos são obrigatórios.");
            return;
        }

        if (!senhaTexto.equals(confirmarTexto)) {
            JOptionPane.showMessageDialog(this, "As senhas não coincidem!");
            return;
        }

        try {
            boolean ok = UsuarioDB.cadastrar(usuario, senhaTexto, nome, mail);
            if (ok) {
                JOptionPane.showMessageDialog(this, "Cadastro feito com sucesso!\nFaça login usando o nome de usuário.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Nome de usuário já existe!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar. Tente novamente.");
        }
    }
}
