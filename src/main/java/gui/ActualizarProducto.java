package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import aplicacion.Coordinador;
import entidades.Producto;

public class ActualizarProducto extends JDialog implements ActionListener{
	private Coordinador miCoordinador;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JButton btnCancelar;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JTextField txtIdProducto;


	/**
	 * Create the dialog.
	 * @param b 
	 * @param ventanaPrincipal 
	 * @param documento 
	 */
	public ActualizarProducto(VentanaPrincipal ventanaPrincipal, boolean modal) {
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
		
		JLabel lblTitulo = new JLabel("ACTUALIZAR PRODUCTO");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		lblTitulo.setBounds(10, 10, 372, 28);
		contentPanel.add(lblTitulo);
				
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.setBounds(10, 38, 380, 178);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(24, 96, 71, 21);
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(89, 96, 86, 20);
		panel.add(txtNombre);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(209, 96, 71, 21);
		panel.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(269, 96, 86, 20);
		panel.add(txtPrecio);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 128, 331, 12);
		panel.add(separator);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(266, 144, 89, 23);
		panel.add(btnCancelar);
	
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBackground(new Color(152, 251, 152));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(146, 144, 100, 23);
		panel.add(btnActualizar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(266, 19, 89, 23);
		btnBuscar.addActionListener(this);
		panel.add(btnBuscar);
		
		JLabel lblidProducto = new JLabel("Id Producto: ");
		lblidProducto.setBounds(89, 23, 71, 14);
		panel.add(lblidProducto);
		
		txtIdProducto = new JTextField();
		txtIdProducto.setBounds(170, 20, 86, 20);
		txtIdProducto.setEnabled(true);
		panel.add(txtIdProducto);
		txtIdProducto.setColumns(10);
		
		

	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnBuscar) {
				
				Long idProducto = Long.parseLong(txtIdProducto.getText());
				Producto miProducto = miCoordinador.consultarProducto(idProducto);
				
				if(miProducto!=null) {
					
					txtNombre.setText(miProducto.getNombreProducto());
					txtPrecio.setText(miProducto.getPrecioProducto()+"");
					
					txtNombre.setEditable(true);
					txtPrecio.setEditable(true);
					txtIdProducto.setEnabled(false);
					
					btnActualizar.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Producto no existente");
				}
				
		}else if(e.getSource()==btnCancelar) {
			
			limpiar();
			
		}else if(e.getSource()==btnActualizar) {
			Producto miProducto = new Producto();
			
			miProducto.setIdProducto(Long.parseLong(txtIdProducto.getText()));
			miProducto.setNombreProducto(txtNombre.getText());
			miProducto.setPrecioProducto(Double.parseDouble(txtPrecio.getText()));
			
			String res = miCoordinador.actualizarProducto(miProducto);
			
			if(res.equals("Producto Actualizada!")) {
				JOptionPane.showMessageDialog(null, "Actualizacion exitosa!!");
				limpiar();
			}else {
				JOptionPane.showMessageDialog(null, res, "ERROR", JOptionPane.ERROR_MESSAGE);
			}
				
		}
	}


	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	
	public void limpiar() {
		// TODO Auto-generated method stub
		txtIdProducto.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtNombre.setEditable(false);
		txtPrecio.setEditable(false);
		btnActualizar.setVisible(false);
	}
	
	public void escirbir() {
		txtIdProducto.setEnabled(true);
	}


}
