package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PartidoFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartidoFrame frame = new PartidoFrame();
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
	public PartidoFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
	}

}
