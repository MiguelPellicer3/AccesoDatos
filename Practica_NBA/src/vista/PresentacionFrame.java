package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class PresentacionFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionFrame frame = new PresentacionFrame();
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
	public PresentacionFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 547);
		
		//MENU
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
		PartidosMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PartidoFrame partidos = new PartidoFrame();
				partidos.setVisible(true);
			}
		});
		menuBar.add(PartidosMenu);
		
		JMenuItem JugadorMenu = new JMenuItem("Jugadores");
		JugadorMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JugadorFrame jugadores = new JugadorFrame();
				jugadores.setVisible(true);
			}
		});
		menuBar.add(JugadorMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ELEMENTOS
		JLabel Autor = new JLabel("Miguel Pellicer Cerezuela");
		Autor.setBounds(10, 11, 195, 32);
		contentPane.add(Autor);
		
		JLabel Presentación = new JLabel("<html>Bienvenidos a la mejor aplicación de la nba.<br>En la pestaña de equipos encontrarás las franquicias.<br>En la pestaña de partidos encontrarás los encuentros disputados por los equipos.<br>En la pestaña de jugadores encontrarás a los mejores Jugadores del mundo y sus estadísticas</html>");
		Presentación.setBounds(10, 162, 365, 146);
		contentPane.add(Presentación);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon("C:\\Users\\DAMDUALAlu7\\git\\AccesoDatos\\Practica_NBA\\img\\logo.png"));
		imagen.setBounds(203, 0, 399, 492);
		contentPane.add(imagen);
	}
}
