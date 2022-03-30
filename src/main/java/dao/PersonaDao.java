package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.swing.JOptionPane;

import org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform;

import aplicacion.Coordinador;
import aplicacion.JPAUtil;
import entidades.Persona;

public class PersonaDao {
	
	Coordinador miCoordinador;
	
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String registrarPersona(Persona miPersona) {
		// TODO Auto-generated method stub
		
		entityManager.getTransaction().begin();
		entityManager.persist(miPersona);
		entityManager.getTransaction().commit();
		
		String resp="Persona Registrada!";
		
		return resp;
	}

	public Persona consultarPersona(Long idPersona) {
		// TODO Auto-generated method stub
		Persona miPersona=entityManager.find(Persona.class, idPersona);
		
		if(miPersona!=null) {
			return miPersona;
		}else {
			return null;
		}

	}

	public List<Persona> consultarListaPersonas() {
		// TODO Auto-generated method stub
		List<Persona> listaPersonas = new ArrayList<Persona>();
		Query query= entityManager.createQuery("SELECT p FROM Persona p");
		listaPersonas=query.getResultList();
		
		return listaPersonas;
	}

	public String actualizarPersona(Persona miPersona) {
		// TODO Auto-generated method stub
		entityManager.getTransaction().begin();		
		entityManager.merge(miPersona);
		entityManager.getTransaction().commit();
		
		String resp="Persona Actualizada!";
		
		return resp;
	}

	public String eliminarPersona(Persona miPersona) {
		// TODO Auto-generated method stub
		String resp="";
		try {
			
			entityManager.getTransaction().begin();
			entityManager.remove(miPersona);
			entityManager.getTransaction().commit();
			resp = "Persona Eliminada!";
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "No se puede eliminar la persona" + "verifique que no tenga registros pendientes", "ERROR", JOptionPane.ERROR_MESSAGE );
		}

		return resp;
	}
	
	public void close() {
		// TODO Auto-generated method stub
		entityManager.close();
		JPAUtil.shutdown();
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}

}
