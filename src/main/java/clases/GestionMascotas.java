package clases;

import java.awt.JobAttributes;
import java.util.List;

import javax.swing.JOptionPane;

import aplicacion.Coordinador;
import dao.MascotaDao;
import entidades.Mascota;
import entidades.Persona;
import dao.PersonaDao;

public class GestionMascotas {
	
	MascotaDao miMascotaDao = new MascotaDao();
	Coordinador miCoordinador;

	private void registrar() {
		// TODO Auto-generated method stub
		Mascota miMascota = new Mascota();
		
		miMascota.setIdMascota(Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de su mascota")));
		miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la Mascota"));
		miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la Raza de la Mascota"));
		miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el Color de la Mascota"));
		miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de la Mascota"));
		
		Long idDuenio=Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento del dueño"));
		Persona duenio = new Persona();
		duenio = new PersonaDao().consultarPersona(idDuenio);
		miMascota.setDuenio(duenio);
		
		System.out.println(miMascotaDao.registrarMascota(miMascota));
		System.out.println();
		
	}

	private void consultar() {
		// TODO Auto-generated method stub
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la Mascota"));
		
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		if(miMascota != null) {
			System.out.println(miMascota);
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro la mascota");
		}
		System.out.println();
	}

	private void consultarLista() {
		// TODO Auto-generated method stub
		System.out.println();
		List<Mascota> listaMascotas = miMascotaDao.consultarListaMascotas();
		
		for(Mascota mascota : listaMascotas) {
			System.out.println(mascota);
		}
	}

	private void consultarListaPorSexo() {
		// TODO Auto-generated method stub
		System.out.println("Lista de Mascotas por sexo");
		String sexo = JOptionPane.showInputDialog("Ingrese el sexo de la mascota");
		
		List<Mascota> listaMascotas =miMascotaDao.consultarListaMascotasPorSexo(sexo);
		
		for(Mascota mascota : listaMascotas) {
			System.out.println(mascota);
		} 
	}

	private void actualizar() {
		// TODO Auto-generated method stub
	    Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la Mascota para actualizar"));
	    Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
	    if (miMascota != null) {
	        System.out.println(miMascota);
	        System.out.println();
	        miMascota.setNombre(JOptionPane.showInputDialog("Ingrese el nombre de la mascota"));
	        miMascota.setRaza(JOptionPane.showInputDialog("Ingrese la raza de la mascota"));
	        miMascota.setColorMascota(JOptionPane.showInputDialog("Ingrese el color de la mascota"));
	        miMascota.setSexo(JOptionPane.showInputDialog("Ingrese el sexo de su mascota"));
	        
	        Long idDuenio=Long.parseLong(JOptionPane.showInputDialog("Ingrese el documento del due�o"));
			Persona duenio=new Persona();//Se genera la instancia para permitir el registro
			duenio.setIdPersona(idDuenio);//se agrega el id solicitado
			miMascota.setDuenio(duenio);//Se agrega el due�o a la mascota
			
	        System.out.println(miMascotaDao.actualizarMascota(miMascota));
	        System.out.println();
	     } else {
	        System.out.println();
	        System.out.println("No se encontr� la mascota");
	     }
	    System.out.println();
	}

	private void eliminar() {
		// TODO Auto-generated method stub
		Long idMascota = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id de la Mascota para eliminar"));
		
		Mascota miMascota = miMascotaDao.consultarMascota(idMascota);
		if(miMascota != null) {
			System.out.println(miMascota);
			System.out.println();
			
			System.out.println(miMascotaDao.eliminarMascota(miMascota));
			System.out.println();
		}else {
			System.out.println();
			System.out.println("No se encontro la mascota");
		}
		System.out.println();
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
	
	
}
