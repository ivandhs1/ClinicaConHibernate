package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import aplicacion.Coordinador;
import entidades.Producto;

public class RegistrarProductosGui extends JDialog implements ActionListener{

	private Coordinador miCoordinador;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JButton btnCancelar;
	private JButton btnRegistrar;
	private JTextField txtIdProducto;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public RegistrarProductosGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 253);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Gestion de Mascotas");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("GESTIONAR PRODUCTOS");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 49, 380, 154);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(25, 66, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(80, 66, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(211, 66, 71, 21);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(269, 66, 86, 20);
		panel.add(txtPrecio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 97, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(269, 120, 89, 23);
		btnCancelar.setBackground(new Color(255, 192, 203));
		panel.add(btnCancelar);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(173, 120, 89, 23);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBackground(new Color(152, 251, 152));
		panel.add(btnRegistrar);
		
		JLabel lblidProducto = new JLabel("Id Producto: ");
		lblidProducto.setBounds(15, 23, 71, 14);
		panel.add(lblidProducto);
		
		txtIdProducto = new JTextField();
		txtIdProducto.setBounds(89, 20, 86, 20);
		panel.add(txtIdProducto);
		txtIdProducto.setColumns(10);
		

	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnRegistrar) {
			
			Producto miProducto = new Producto();
			
			miProducto.setIdProducto(Long.parseLong(txtIdProducto.getText()));
			miProducto.setNombreProducto(txtNombre.getText());
			miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
			
			String res = miCoordinador.registrarProducto(miProducto);
			
			if(res.equals("Producto Registrado!")) {
				JOptionPane.showMessageDialog(null, "Registro Exitoso!!");
				limpiar();
			}else {
				JOptionPane.showMessageDialog(null, "Error en el registro", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}else if(e.getSource()==btnCancelar) {
			limpiar();
		}
	}


	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}

	public void limpiar() {

		txtIdProducto.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
	}

}
