import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistros extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldCarnet;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistros frame = new VentanaRegistros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaRegistros() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 228);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitulo = new JLabel("Registrar Estudiante");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		
		JPanel panelCentro = new JPanel();
		contentPane.add(panelCentro, BorderLayout.CENTER);
		panelCentro.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelIz = new JPanel();
		panelCentro.add(panelIz);
		panelIz.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		panelIz.add(lblNombre);
		
		textFieldNombre = new JTextField();
		panelIz.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblCarnet = new JLabel("Carnet:");
		lblCarnet.setHorizontalAlignment(SwingConstants.CENTER);
		panelIz.add(lblCarnet);
		
		textFieldCarnet = new JTextField();
		panelIz.add(textFieldCarnet);
		textFieldCarnet.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		panelCentro.add(textArea);
		
		JPanel panelAb = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelAb.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panelAb, BorderLayout.SOUTH);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaUsuarios.add(new Usuario(textFieldCarnet.getText(),textFieldNombre.getText()));
				textArea.setText("");
				Usuario aux = ListaUsuarios.getPrimero();
				while(aux != null) {
					textArea.append("Nombre: "+ aux.getNombre() + ", Carnet: "+aux.getCarnet()+"\n");
					aux=aux.getSiguiente();
				}
				JOptionPane.showMessageDialog(null, "Se ha registrado al estudiante");
			}
		});
		panelAb.add(btnRegistrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				Usuario aux = ListaUsuarios.getPrimero();
				while(aux != null) {
					textArea.append("Nombre: "+ aux.getNombre() + ", Carnet: "+aux.getCarnet()+"\n");
					aux=aux.getSiguiente();
				}
			}
		});
		panelAb.add(btnActualizar);
	}

}
