package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import aplicacion.Coordinador;
import entidades.Mascota;
import entidades.Persona;

public class ListarPersonas extends JDialog {
	
	private JPanel miPanel;
	private Coordinador miCoordinador;
	private ArrayList<Persona> personas;
	private JTable miTabla;
	private JLabel titulo;
	private JScrollPane miScrol;
	private JTextArea txtPersonas;
	
	public ListarPersonas() {
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
		
		txtPersonas = new JTextArea();
		miScrol.setViewportView(txtPersonas);
		
		add(miPanel);
		
	}

	public void llenar() {
		List<Persona> listaMascotas = miCoordinador.listaPersonas();
		
		for (Persona persona : listaMascotas) {
			System.out.println(persona);
			txtPersonas.setText(txtPersonas.getText()+persona.imprimir()+"\n");
		}
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	
	public void vaciar() {
		txtPersonas.setText("");
	}

		
}
