package JFrames;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InsertarEmpleado extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertarEmpleado dialog = new InsertarEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertarEmpleado() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Número");
			lblNewLabel.setBounds(10, 11, 71, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblApellido = new JLabel("Apellido");
			lblApellido.setBounds(10, 36, 71, 14);
			contentPanel.add(lblApellido);
		}
		{
			JLabel lblOficio = new JLabel("Oficio");
			lblOficio.setBounds(10, 61, 71, 14);
			contentPanel.add(lblOficio);
		}
		{
			JLabel lblDirector = new JLabel("Director");
			lblDirector.setBounds(10, 86, 71, 14);
			contentPanel.add(lblDirector);
		}
		{
			JLabel lblFechaAlta = new JLabel("Fecha Alta");
			lblFechaAlta.setBounds(10, 111, 71, 14);
			contentPanel.add(lblFechaAlta);
		}
		{
			JLabel lblSalario = new JLabel("Salario");
			lblSalario.setBounds(10, 136, 71, 14);
			contentPanel.add(lblSalario);
		}
		{
			JLabel lblNDep = new JLabel("Nº Dep");
			lblNDep.setBounds(10, 161, 71, 14);
			contentPanel.add(lblNDep);
		}
		{
			textField = new JTextField();
			textField.setBounds(91, 8, 150, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(91, 33, 150, 20);
			contentPanel.add(textField_1);
		}
		{
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(91, 58, 150, 20);
			contentPanel.add(textField_2);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(91, 83, 150, 20);
			contentPanel.add(textField_3);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(91, 108, 150, 20);
			contentPanel.add(textField_4);
		}
		{
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(91, 133, 150, 20);
			contentPanel.add(textField_5);
		}
		{
			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(91, 158, 150, 20);
			contentPanel.add(textField_6);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
