package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import aplicacion.Coordinador;
import entidades.Mascota;

public class ListarMascotasGui extends JDialog {

	private JPanel miPanel;
	private Coordinador miCoordinador;
	private ArrayList<Mascota> mascotas;
	private JTable miTabla;
	private JLabel titulo;
	private JScrollPane miScrol;
	
	public ListarMascotasGui() {
		setSize( 672, 449);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		setTitle("lista de Mascotas");
		iniciarComponentes();
	}

	private void iniciarComponentes() {
		
		miPanel = new JPanel();
		miPanel.setLayout(null);
		
		titulo = new JLabel("Lista de Mascotas");
		titulo.setBounds(220,20,180,30);
		titulo.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		miPanel.add(titulo);
		
		miScrol = new JScrollPane();
		miScrol.setBounds(10,80,630,247);
		miPanel.add(miScrol);
		
		add(miPanel);
	}

	public void setCoordinador(Coordinador miCoordinador2) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}

	

}
