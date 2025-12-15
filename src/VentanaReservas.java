import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaReservas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private JTextField textFieldCarnet;
    private JTextField textFieldSala1;
    private JTextField textFieldSala2;
    private JTextField textFieldSala3;
    private JTextField textFieldSala4;

    private JTextArea textAreaUsuarios;
    private JTextArea textAreaQueue;

    private JLabel lblSala1;
    private JLabel lblSala2;
    private JLabel lblSala3;
    private JLabel lblSala4;

    private ListaSalas salas;
    private GestorSalas gestor;

    public VentanaReservas() {
        salas = new ListaSalas();
        salas.addLast(new Sala(1));
        salas.addLast(new Sala(2));
        salas.addLast(new Sala(3));
        salas.addLast(new Sala(4));
        gestor = new GestorSalas(salas);
        Usuario aux = ListaUsuarios.getPrimero();
        while (aux != null) {
            gestor.registrarUsuario(aux.getCarnet(), aux.getNombre());
            aux = aux.getSiguiente();
        }
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 650, 350);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Reservar Sala");
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelCentro = new JPanel(new GridLayout(1, 2));
        contentPane.add(panelCentro, BorderLayout.CENTER);

        JPanel panelIz = new JPanel(new BorderLayout());
        panelCentro.add(panelIz);

        JPanel panelCarnet = new JPanel(new GridLayout(1, 2));
        panelCarnet.add(new JLabel("Carnet:", SwingConstants.CENTER));
        textFieldCarnet = new JTextField();
        panelCarnet.add(textFieldCarnet);
        panelIz.add(panelCarnet, BorderLayout.NORTH);

        JPanel panelTextAreas = new JPanel(new GridLayout(1, 2));
        textAreaUsuarios = new JTextArea();
        textAreaQueue = new JTextArea();
        panelTextAreas.add(new JScrollPane(textAreaUsuarios));
        panelTextAreas.add(new JScrollPane(textAreaQueue));
        panelIz.add(panelTextAreas, BorderLayout.CENTER);

        JPanel panelDer = new JPanel(new GridLayout(4, 2));
        panelCentro.add(panelDer);

        lblSala1 = crearLabelSala("Sala 1", panelDer);
        textFieldSala1 = crearTextFieldSala(panelDer);

        lblSala2 = crearLabelSala("Sala 2", panelDer);
        textFieldSala2 = crearTextFieldSala(panelDer);

        lblSala3 = crearLabelSala("Sala 3", panelDer);
        textFieldSala3 = crearTextFieldSala(panelDer);

        lblSala4 = crearLabelSala("Sala 4", panelDer);
        textFieldSala4 = crearTextFieldSala(panelDer);

        JPanel panelAb = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        contentPane.add(panelAb, BorderLayout.SOUTH);

        JButton btnAsignar = new JButton("Asignar Sala");
        panelAb.add(btnAsignar);

        JButton btnSala1 = new JButton("Liberar Sala 1");
        JButton btnSala2 = new JButton("Liberar Sala 2");
        JButton btnSala3 = new JButton("Liberar Sala 3");
        JButton btnSala4 = new JButton("Liberar Sala 4");

        panelAb.add(btnSala1);
        panelAb.add(btnSala2);
        panelAb.add(btnSala3);
        panelAb.add(btnSala4);

        btnAsignar.addActionListener(e -> {
            Usuario u = gestor.ocuparSala(textFieldCarnet.getText());
            actualizarTodo();
            if (u == null) {
                JOptionPane.showMessageDialog(this, "Usuario enviado a cola o no registrado");
            }
        });

        btnSala1.addActionListener(e -> liberarSala(1));
        btnSala2.addActionListener(e -> liberarSala(2));
        btnSala3.addActionListener(e -> liberarSala(3));
        btnSala4.addActionListener(e -> liberarSala(4));

        actualizarTodo();
    }

    private JLabel crearLabelSala(String texto, JPanel panel) {
        JLabel lbl = new JLabel(texto, SwingConstants.CENTER);
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel.add(lbl);
        return lbl;
    }

    private JTextField crearTextFieldSala(JPanel panel) {
        JTextField tf = new JTextField();
        tf.setEditable(false);
        tf.setBackground(Color.GREEN);
        panel.add(tf);
        return tf;
    }

    private void liberarSala(int id) {
        gestor.desocuparSala(id);
        actualizarTodo();
    }

    private void actualizarTodo() {
        actualizarSalas();
        actualizarUsuarios();
        actualizarCola();
    }

    private void actualizarUsuarios() {
        textAreaUsuarios.setText("");
        Usuario aux = ListaUsuarios.getPrimero();
        while (aux != null) {
            textAreaUsuarios.append(aux.getNombre() + " - " + aux.getCarnet() + "\n");
            aux = aux.getSiguiente();
        }
    }

    private void actualizarCola() {
        textAreaQueue.setText("");
        textAreaQueue.append("Cola activa (ver consola)");
    }

    private void actualizarSalas() {
        actualizarSalaVisual(1, lblSala1, textFieldSala1);
        actualizarSalaVisual(2, lblSala2, textFieldSala2);
        actualizarSalaVisual(3, lblSala3, textFieldSala3);
        actualizarSalaVisual(4, lblSala4, textFieldSala4);
    }

    private void actualizarSalaVisual(int id, JLabel lbl, JTextField tf) {
        Sala aux = salas.getPrimerNodo();
        while (aux != null) {
            if (aux.getID() == id) {
                if (aux.getEstado().equals("Libre")) {
                    tf.setBackground(Color.GREEN);
                    lbl.setText("Sala " + id + " - Libre");
                } else {
                    tf.setBackground(Color.RED);
                    lbl.setText("Sala " + id + " - Ocupada");
                }
                return;
            }
            aux = aux.getSiguiente();
        }
    }
}
