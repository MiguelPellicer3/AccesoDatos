package JFrames;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameEmpleados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdField;
	private JTextField NombreField;
	private JTextField ApellidoField;
	private JTextField OficioField;
	private JTextField FechaField;
	private JTextField SalarioField;
	private JTextField DirectorField;
	private JTextField DepartamentoField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameEmpleados frame = new FrameEmpleados();
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
	public FrameEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 421);
		
		
		//Menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Inicio");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrameInicio frame = new FrameInicio();
				frame.setVisible(true);
			}
		});
		menuBar.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Departamentos");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameDepartamentos frame = new FrameDepartamentos();
				frame.setVisible(true);
				
			}
		});
		menuBar.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Empelados");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameEmpleados frame = new FrameEmpleados();
				frame.setVisible(true);
			}
		});
		menuBar.add(mntmNewMenuItem_2);

		//CONTENTPANE
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//JLABEL
		
		JLabel lblInsertarIdEmpleado = new JLabel("Insertar Id Empleado");
		lblInsertarIdEmpleado.setBounds(10, 11, 133, 42);
		contentPane.add(lblInsertarIdEmpleado);
		
		JLabel lblNewLabel_1 = new JLabel("Para Consultar Eliminar o Modificar");
		lblNewLabel_1.setBounds(10, 47, 178, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Número Empleado");
		lblNewLabel.setBounds(10, 87, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(10, 112, 51, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Oficio");
		lblNewLabel_2_1.setBounds(10, 137, 51, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Fecha de Alta");
		lblNewLabel_2_1_1.setBounds(10, 162, 85, 14);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Salario");
		lblNewLabel_2_1_1_1.setBounds(10, 198, 51, 14);
		contentPane.add(lblNewLabel_2_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("Director");
		lblNewLabel_3.setBounds(10, 223, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nombre del Departamento");
		lblNewLabel_3_1.setBounds(10, 248, 133, 14);
		contentPane.add(lblNewLabel_3_1);
		
		//FIELDS
		
		IdField = new JTextField();
		IdField.setColumns(10);
		IdField.setBounds(203, 26, 96, 20);
		contentPane.add(IdField);
		
		NombreField = new JTextField();
		NombreField.setBounds(157, 84, 194, 20);
		contentPane.add(NombreField);
		NombreField.setColumns(10);
		
		ApellidoField = new JTextField();
		ApellidoField.setColumns(10);
		ApellidoField.setBounds(157, 109, 194, 20);
		contentPane.add(ApellidoField);
		
		OficioField = new JTextField();
		OficioField.setColumns(10);
		OficioField.setBounds(157, 134, 194, 20);
		contentPane.add(OficioField);
		
		FechaField = new JTextField();
		FechaField.setColumns(10);
		FechaField.setBounds(157, 159, 194, 20);
		contentPane.add(FechaField);
		
		SalarioField = new JTextField();
		SalarioField.setColumns(10);
		SalarioField.setBounds(157, 195, 194, 20);
		contentPane.add(SalarioField);
		
		DirectorField = new JTextField();
		DirectorField.setColumns(10);
		DirectorField.setBounds(157, 220, 194, 20);
		contentPane.add(DirectorField);
		
		DepartamentoField = new JTextField();
		DepartamentoField.setColumns(10);
		DepartamentoField.setBounds(157, 245, 194, 20);
		contentPane.add(DepartamentoField);
		
		
		//BUTTON
		
		//Insert
		JButton btnInsertar = new JButton("Insertar Empleado");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInsertar.setBounds(477, 94, 127, 50);
		contentPane.add(btnInsertar);
		
		//Get by Id
		JButton btnConsultarEmpleado = new JButton("Consultar Empleado");
		btnConsultarEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsultarEmpleado.setBounds(477, 11, 127, 50);
		contentPane.add(btnConsultarEmpleado);
		
		//Modify
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModificar.setBounds(477, 180, 127, 50);
		contentPane.add(btnModificar);
		
		
		//Delete
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEliminar.setBounds(477, 263, 127, 50);
		contentPane.add(btnEliminar);
	}

}
