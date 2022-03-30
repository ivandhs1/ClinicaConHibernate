package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.JobAttributes;
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
import entidades.Persona;
import entidades.PersonasProductos;
import entidades.Producto;

public class ComprarProductoGui extends JDialog implements ActionListener {
	
	
	
	private Coordinador miCoordinador;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtProducto;
	private JButton btnCancelar;
	private JButton btnComprar;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public ComprarProductoGui(VentanaPrincipal ventanaPrincipal, boolean modal) {
		super(ventanaPrincipal,modal);
		setSize( 412, 266);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Consulta de Productos");
		iniciarComponentes();
		
		
	}


	private void iniciarComponentes() {
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblTitulo = new JLabel("COMPRAR PRODUCTO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 38, 380, 178);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("id Persona:");
		lblNombre.setBounds(24, 60, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(87, 60, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblProducto = new JLabel("id Producto:");
		lblProducto.setBounds(200, 60, 71, 21);
		panel.add(lblProducto);
		
		txtProducto = new JTextField();
		txtProducto.setColumns(10);
		txtProducto.setBounds(266, 60, 86, 20);
		panel.add(txtProducto);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(34, 92, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(200, 115, 89, 23);
		panel.add(btnCancelar);
	
		btnComprar = new JButton("Comprar");
		btnComprar.setBackground(new Color(152, 251, 152));
		btnComprar.addActionListener(this);
		btnComprar.setBounds(87, 115, 100, 23);
		panel.add(btnComprar);

	}
	

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==btnComprar) {
			
			PersonasProductos miProducto = new PersonasProductos();
			miProducto.setPersonaId(Long.parseLong(txtNombre.getText()));
			miProducto.setProductoId(Long.parseLong(txtProducto.getText()));
			
			Producto miProC = miCoordinador.consultarProducto(miProducto.getProductoId());
			Persona miPersona = miCoordinador.consultarPersona(miProducto.getPersonaId());
			miProC.getListaPersonas().add(miPersona);
			String res =miCoordinador.realizarCompra(miProducto);
			
			if(res.equals("OK")) {
				JOptionPane.showMessageDialog(null,"COMPRA EXITOSA !!!");
				limpiar();
	
			}else {
				JOptionPane.showMessageDialog(null,"NO SE PUEDE REALIZAR LA COMPRA", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			
			
		}else if(e.getSource()==btnCancelar) {
			limpiar();
		}
		
		
	}

	public void limpiar() {

		txtProducto.setText("");
		txtNombre.setText("");
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	
	

}
