import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DiarioTela extends JFrame {
    private JTextField campoTitulo;
    private JTextArea areaTexto;
    private int idUsuario;

    public DiarioTela(int idUsuario) {
        this.idUsuario = idUsuario;

        setTitle("Meu Diário");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        campoTitulo = new JTextField();
        campoTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        campoTitulo.setPreferredSize(new Dimension(600, 25));

        areaTexto = new JTextArea();
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 14));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);

        JButton salvar = new JButton("Salvar Entrada");
        JButton ver = new JButton("Ver Entradas");

        salvar.addActionListener(e -> salvar());
        ver.addActionListener(e -> verEntradas());

        setLayout(new BorderLayout());

        JPanel painelTopo = new JPanel(new BorderLayout());
        painelTopo.add(new JLabel("Título da Entrada:"), BorderLayout.NORTH);
        painelTopo.add(campoTitulo, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        botoes.add(salvar);
        botoes.add(ver);

        add(painelTopo, BorderLayout.NORTH);
        add(new JScrollPane(areaTexto), BorderLayout.CENTER);
        add(botoes, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void salvar() {
        try {
            String titulo = campoTitulo.getText().trim();
            String texto = areaTexto.getText().trim();
            if (titulo.isEmpty() || texto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha o título e o texto.");
                return;
            }
            DiarioDB.salvarEntrada(idUsuario, titulo, texto);
            JOptionPane.showMessageDialog(this, "Entrada salva com sucesso!");
            campoTitulo.setText("");
            areaTexto.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void verEntradas() {
            try {
                List<String> entradas = DiarioDB.listarEntradas(idUsuario);
                JTextArea historico = new JTextArea();
                historico.setFont(new Font("Arial", Font.PLAIN, 13));
                historico.setLineWrap(true);
                historico.setWrapStyleWord(true);
                historico.setEditable(false);

                for (String e : entradas)
                    historico.append(e);

                JScrollPane scroll = new JScrollPane(historico);
                scroll.setPreferredSize(new Dimension(500, 400));
                JOptionPane.showMessageDialog(this, scroll, "Histórico", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
        }

    }
}
