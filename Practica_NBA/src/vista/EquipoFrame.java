package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import repository.EquipoRepository;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

public class EquipoFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCiudad;
	private JTextField txtConferencia;
	private JTextField txtDivision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EquipoFrame frame = new EquipoFrame();
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
	public EquipoFrame() {
		//Repository Equipo
		EquipoRepository _repository = new EquipoRepository();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 648, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		// MENU
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem EquipoMenu = new JMenuItem("Equipos");
		EquipoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EquipoFrame equipos = new EquipoFrame();
				equipos.setVisible(true);
			}
		});
		menuBar.add(EquipoMenu);

		JMenuItem PartidosMenu = new JMenuItem("Partidos");
		EquipoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PartidoFrame partidos = new PartidoFrame();
				partidos.setVisible(true);
			}
		});
		menuBar.add(PartidosMenu);

		JMenuItem JugadorMenu = new JMenuItem("Jugadores");
		EquipoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JugadorFrame jugadores = new JugadorFrame();
				jugadores.setVisible(true);
			}
		});
		menuBar.add(JugadorMenu);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JComboBox<String> comboBox = new JComboBox<String>();
		List<String> combo = _repository.getNombres();
		for (String string : combo) {
			comboBox.addItem(string);
		}
		comboBox.setBounds(10, 10, 313, 22);
		contentPane.add(comboBox);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(58, 64, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(58, 107, 46, 14);
		contentPane.add(lblCiudad);
		
		JLabel lblConferencia = new JLabel("Conferencia");
		lblConferencia.setBounds(58, 150, 67, 14);
		contentPane.add(lblConferencia);
		
		JLabel lblDivision = new JLabel("Division");
		lblDivision.setBounds(58, 191, 46, 14);
		contentPane.add(lblDivision);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(149, 61, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCiudad = new JTextField();
		txtCiudad.setBounds(149, 104, 86, 20);
		contentPane.add(txtCiudad);
		txtCiudad.setColumns(10);
		
		txtConferencia = new JTextField();
		txtConferencia.setBounds(149, 147, 86, 20);
		contentPane.add(txtConferencia);
		txtConferencia.setColumns(10);
		
		txtDivision = new JTextField();
		txtDivision.setBounds(149, 188, 86, 20);
		contentPane.add(txtDivision);
		txtDivision.setColumns(10);
		
		JList listaJugadores = new JList();
		listaJugadores.setBounds(405, 320, 202, -263);
		contentPane.add(listaJugadores);
		
		JButton btncCrear = new JButton("CREAR");
		btncCrear.setBounds(10, 242, 89, 23);
		contentPane.add(btncCrear);
		
		JButton btnEditar = new JButton("EDITAR");
		btnEditar.setBounds(149, 242, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(71, 307, 89, 23);
		contentPane.add(btnEliminar);
		
	}
}
