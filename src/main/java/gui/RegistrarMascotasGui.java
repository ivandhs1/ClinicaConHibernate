package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import aplicacion.Coordinador;
import entidades.Mascota;
import entidades.Persona;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarMascotasGui extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIdDueno;
	private JTextField txtNombre;
	private JTextField txtRaza;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private Coordinador miCoordinador;
	private JComboBox comboBoxSexo, comboBoxColor;
	private JTextField txtIdMascota;
	private JLabel lblResultado;
	private Long docu;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public RegistrarMascotasGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 408, 288);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTIONAR MASCOTAS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 370, 192);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblDueno = new JLabel("Id Due\u00F1o:");
		lblDueno.setBounds(199, 17, 71, 21);
		panel.add(lblDueno);
		
		txtIdDueno = new JTextField();
		txtIdDueno.setBounds(269, 17, 86, 20);
		panel.add(txtIdDueno);
		txtIdDueno.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 49, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(88, 49, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblRaza = new JLabel("Raza:");
		lblRaza.setBounds(214, 49, 71, 21);
		panel.add(lblRaza);
		
		txtRaza = new JTextField();
		txtRaza.setColumns(10);
		txtRaza.setBounds(269, 49, 86, 20);
		panel.add(txtRaza);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 127, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(271, 150, 89, 23);
		btnCancelar.setBackground(new Color(255, 192, 203));
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(172, 150, 89, 23);
		btnRegistrar.setBackground(new Color(152, 251, 152));
		btnRegistrar.addActionListener(this);
		panel.add(btnRegistrar);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(24, 81, 71, 21);
		panel.add(lblSexo);
		
		comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Macho", "Hembra"}));
		comboBoxSexo.setBounds(88, 81, 86, 22);
		panel.add(comboBoxSexo);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(214, 82, 71, 21);
		panel.add(lblColor);
		
		comboBoxColor = new JComboBox();
		comboBoxColor.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Caf\u00E9", "Gris", "Manchas"}));
		comboBoxColor.setBounds(269, 81, 86, 22);
		panel.add(comboBoxColor);
		
		txtIdMascota = new JTextField();
		txtIdMascota.setBounds(88, 17, 86, 20);
		panel.add(txtIdMascota);
		
		JLabel lblIdMascota = new JLabel("Id Mascota:");
		lblIdMascota.setBounds(24, 20, 71, 14);
		panel.add(lblIdMascota);
		
		lblResultado = new JLabel("");
		lblResultado.setBounds(10, 127, 345, 14);
		panel.add(lblResultado);
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnRegistrar) {

			Mascota miMascota = new Mascota();
			miMascota.setIdMascota(Long.parseLong(txtIdMascota.getText()));
			miMascota.setNombre(txtNombre.getText());
			miMascota.setRaza(txtRaza.getText());
			miMascota.setSexo((String) comboBoxSexo.getSelectedItem());
			miMascota.setColorMascota((String) comboBoxColor.getSelectedItem());
			
			
			Persona miPersona = miCoordinador.consultarPersona(Long.parseLong(txtIdDueno.getText()));
			
			if(miPersona != null) {
				
				miMascota.setDuenio(miPersona);
				
				String res = miCoordinador.registrarMascota(miMascota);
				
				if(res.equals("Mascota Registrada!")) {
					JOptionPane.showMessageDialog(null,"REGISTRO EXITOSO !!!");
					limpiar();
				}else {
					JOptionPane.showMessageDialog(null, "Error en el registro", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			}else {
				lblResultado.setText("Id de Due?o no existente, Porfavor ingrese uno existente");
			}
			
		}if(e.getSource()==btnCancelar) {
			limpiar();
		}
		
	}
	
	public void ConID(Long id) {
		txtIdDueno.setEditable(false);
		txtIdDueno.setText(String.valueOf(id));
	}


	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	
	public void atraparid(long id) {
		
		txtIdDueno.setText(id+"");
		txtIdDueno.setEnabled(false);
		
	}


	public void limpiar() {
		// TODO Auto-generated method stub
		txtIdDueno.setText("");
		txtIdMascota.setText("");
		txtNombre.setText("");
		txtRaza.setText("");
		
	}
}
