package JFrames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import modelo.Departamentos;
import modelo.Empleados;
import tools.HibernateUtil;
import tools.JFrameMetodos;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

public class FrameDepartamentos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField IdField;
	private JTextField NumeroField;
	private JTextField LocalidadField;
	private JTextField NombreField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDepartamentos frame = new FrameDepartamentos();
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
	public FrameDepartamentos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 417);
		
		//MENÚ
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
				frame.contentPane.setVisible(true);
				
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
		JLabel lblNewLabel = new JLabel("Insertar Id Departamento");
		lblNewLabel.setBounds(10, 8, 133, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Para Consultar Eliminar o Modificar");
		lblNewLabel_1.setBounds(10, 39, 178, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Empleados");
		lblNewLabel_2.setBounds(28, 165, 96, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel numero = new JLabel("Numero");
		numero.setBounds(28, 84, 96, 14);
		contentPane.add(numero);
		
		JLabel nombre = new JLabel("Nombre");
		nombre.setBounds(28, 109, 96, 14);
		contentPane.add(nombre);
		
		JLabel localidad = new JLabel("Localidad");
		localidad.setBounds(28, 140, 96, 14);
		contentPane.add(localidad);
		
		JList<Empleados> listaEmpleados = new JList<Empleados>();
		listaEmpleados.setBounds(28, 190, 288, 149);
		contentPane.add(listaEmpleados);
		DefaultListModel<Empleados> lista= new DefaultListModel<Empleados>();
		listaEmpleados.setModel(lista);
		
		//JFIELD
		NumeroField = new JTextField();
		NumeroField.setBounds(134, 81, 86, 20);
		contentPane.add(NumeroField);
		NumeroField.setColumns(10);
		
		LocalidadField = new JTextField();
		LocalidadField.setBounds(134, 137, 86, 20);
		contentPane.add(LocalidadField);
		LocalidadField.setColumns(10);
		
		NombreField = new JTextField();
		NombreField.setBounds(134, 106, 86, 20);
		contentPane.add(NombreField);
		NombreField.setColumns(10);
		
		IdField = new JTextField();
		IdField.setBounds(201, 19, 96, 20);
		contentPane.add(IdField);
		IdField.setColumns(10);
		
		//BUTTONS
		
		//Insert
		JButton btnInsertar = new JButton("Insertar Departamento");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session sesion = sessionFactory.openSession();
				String numero=(NumeroField.getText());
				int no = Integer.parseInt(numero);
				String name = NombreField.getText();
				String local = LocalidadField.getText();
				if(no>0 && !name.isEmpty() && !local.isEmpty()) {
					Departamentos dep = new Departamentos();
					dep.setDptoNo(no);
					dep.setDnombre(name);
					dep.setLoc(local);
					Boolean res =JFrameMetodos.insertarDepartamento(sesion, dep);
					if(res) {JOptionPane.showMessageDialog(null, "¡Departamento Insertado!");}
				}else {
					JOptionPane.showMessageDialog(null, "Rellena los Campos Número, Nombre y Localidad correctamente");
				}
				sesion.close();
			}
		});
		btnInsertar.setBounds(397, 90, 199, 52);
		contentPane.add(btnInsertar);
		
		
		//Get by Id
		JButton btnMostar = new JButton("Mostrar un único departamento");
		btnMostar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session sesion = sessionFactory.openSession();
				String text = IdField.getText();
				
				if(!text.isEmpty()) {
					int id = Integer.parseInt(text);
					Departamentos dep =  tools.Practica.getById(sesion, id );
					if(dep!=null) {
						NumeroField.setText(dep.getDptoNo()+"");
						NombreField.setText(dep.getDnombre());
						LocalidadField.setText(dep.getLoc());
						
						if(dep.getEmpleadoses().size()>0) {
							for (Empleados empleados : dep.getEmpleadoses()) {
								lista.addElement(empleados);
							}
						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Introduce un Id para filtar por departamento");
				}
				sesion.close();
			}
		});
		btnMostar.setBounds(397, 20, 199, 52);
		contentPane.add(btnMostar);
		
		
		//Modify
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session sesion = sessionFactory.openSession();
				int no = Integer.parseInt(NumeroField.getText());
				String name = NombreField.getText();
				String local = LocalidadField.getText();
				if(no>0 && !name.isEmpty() && !local.isEmpty()) {
					Departamentos dep = new Departamentos();
					dep.setDptoNo(no);
					dep.setDnombre(name);
					dep.setLoc(local);
					Boolean res = JFrameMetodos.modificarDepartamento(sesion, dep);
					if(res) {JOptionPane.showMessageDialog(null, "Modificado correctamente");}
				}else {
					JOptionPane.showMessageDialog(null, "Rellena los Campos Número, Nombre y Localidad correctamente");
				}
				sesion.close();
			}
		});
		btnModificar.setBounds(397, 159, 199, 52);
		contentPane.add(btnModificar);
		
		
		//Delete
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				Session sesion = sessionFactory.openSession();
				String num = IdField.getText();
				if(!num.isEmpty()) {
					int id = Integer.parseInt(num);
					Boolean res =JFrameMetodos.eliminarDepartamento(sesion, id);
					if(res) {JOptionPane.showMessageDialog(null, "Eliminado correctamente");}
				}else {
					JOptionPane.showMessageDialog(null, "Id no válido");
				}
				sesion.close();
			}
		});
		btnEliminar.setBounds(397, 222, 199, 59);
		contentPane.add(btnEliminar);
		
		
		
		
	}
}
