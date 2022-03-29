package clases;

import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

import aplicacion.Coordinador;
import dao.PersonaDao;
import entidades.Mascota;
import entidades.Nacimiento;
import entidades.Persona;

public class GestionPersonas {
	
	Coordinador miCoordinador;
	PersonaDao miPersonaDao;
		
	private void registrar() {
		// TODO Auto-generated method stub
		Persona miPersona = new Persona();
		miPersona.setIdPersona(Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento de la persona")));
		miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la Persona"));
		miPersona.setTelefono(JOptionPane.showInputDialog("INgrese el telefono de la Persona"));
		miPersona.setProfesion(JOptionPane.showInputDialog("Ingrese su Profesion"));
		miPersona.setTipo(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo")));
		
		miPersona.setNacimiento(obtenerDatosNacimiento());
		
		int opc=0;
		
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog("Desea Registrar Una Mascota?"+"\n1.SI\n2.No"));
			
			if(opc==1) {
				Mascota miMascota = new Mascota();
				miMascota.setIdMascota(Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la mascota")));
				miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota"));
				miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de la mascota"));
				miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de la mascota"));
				miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de su mascota"));
				miMascota.setDuenio(miPersona);
				
				miPersona.getListaMascotas().add(miMascota);
			}
			
		} while (opc!=2);
		
		   String registro = miPersonaDao.registrarPersona(miPersona);
		   miPersona.getNacimiento().setIdNacimiento(miPersonaDao.consultarPersona(miPersona.getIdPersona()).getNacimiento().getIdNacimiento());
		   System.out.println(miPersona);
		
	}

	private Nacimiento obtenerDatosNacimiento() {
		// TODO Auto-generated method stub
		int dia=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DIA de Nacimiento"));
		int mes=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el MES de Nacimiento"));
		int annio=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el AÑO de Nacimiento"));
		
		Nacimiento datosNacimientos = new Nacimiento();
		datosNacimientos.setIdNacimiento(null);
		datosNacimientos.setFechaNacimeinto(LocalDate.of(annio, mes, dia));
		datosNacimientos.setCiudadNAcimiento(JOptionPane.showInputDialog("Ingrese la ciudad de Nacimiento"));
		datosNacimientos.setDepartamentoNacimiento(JOptionPane.showInputDialog("INgrese el departamento de Nacimiento"));
		datosNacimientos.setPaisNacimiento(JOptionPane.showInputDialog("Ingrese el pais de Nacimiento"));
		
		return datosNacimientos;
		
	}

	private void consultar() {
		// TODO Auto-generated method stub
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la Persona"));
		
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if(miPersona != null) {
			System.out.println(miPersona);
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro la persona");
		}
		
	}

	private void consultarLista() {
		// TODO Auto-generated method stub

		System.out.println("Lista de Personas");
		List<Persona> listaPersonas = miPersonaDao.consultarListaPersonas();
		
		for (Persona persona : listaPersonas) {
			System.out.println(persona.toString());
		}
	}

	private void actualizarNombre() {
		// TODO Auto-generated method stub
		
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la persona actualizar su Nombre"));
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if(miPersona != null) {
			System.out.println(miPersona);
			System.out.println();
			miPersona.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la Persona"));
			System.out.println(miPersonaDao.actualizarPersona(miPersona));
			System.out.println();
			
		}else {
			System.out.println();
			System.out.println("No se encontro la Persona");
		}
		System.out.println();
		
	}

	private void eliminar() {
		// TODO Auto-generated method stub
		Long idPersona = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la Persona para eliminar"));
		Persona miPersona = miPersonaDao.consultarPersona(idPersona);
		
		if(miPersona != null) {
			System.out.println(miPersona);
			System.out.println();
			
			System.out.println(miPersonaDao.eliminarPersona(miPersona));
			System.out.println();
		}else {
			System.out.println();
			System.out.println();
		}
		System.out.println();
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}

	
}

