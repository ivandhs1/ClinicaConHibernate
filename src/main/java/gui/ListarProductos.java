package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import aplicacion.Coordinador;
import entidades.PersonasProductos;

public class ListarProductos extends JDialog implements ActionListener{
	
	private JPanel miPanel;
	private Coordinador miCoordinador;
	private JTable miTabla;
	private JLabel titulo;
	private JScrollPane miScrol;
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
		
		titulo = new JLabel("Lista de Personas");
		titulo.setBounds(220,20,180,30);
		titulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		miPanel.add(titulo);
		
		miScrol = new JScrollPane();
		miScrol.setBounds(10,80,630,247);
		miPanel.add(miScrol);
		
		add(miPanel);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}



}
