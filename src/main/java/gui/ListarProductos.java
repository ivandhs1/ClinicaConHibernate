package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import aplicacion.Coordinador;
import entidades.PersonasProductos;
import entidades.Producto;

import java.awt.TextArea;

public class ListarProductos extends JDialog{
	
	private JPanel miPanel;
	private Coordinador miCoordinador;
	private JTable miTabla;
	private TextArea textArea;
	private JLabel titulo;
	private PersonasProductos produc;
	public ListarProductos() {
		setSize( 672, 449);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("lista de Personas");
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		
		miPanel = new JPanel();
		miPanel.setLayout(null);
		
		titulo = new JLabel("Lista de Productos");
		titulo.setBounds(220,20,180,30);
		titulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		miPanel.add(titulo);
		
		getContentPane().add(miPanel);
		
		textArea = new TextArea();
		textArea.setBounds(21, 56, 612, 329);
		miPanel.add(textArea);
		textArea.setEditable(false);
		
	}


	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	
	public void llenar(List<Producto> listaProductos){
		textArea.setText("");
		Producto miProducto = new Producto();
		for(int i= 0; i<listaProductos.size(); i++) {
			miProducto = listaProductos.get(i);
			textArea.setText(textArea.getText()+miProducto.toString()+"\n\n");
		}
	}
}
