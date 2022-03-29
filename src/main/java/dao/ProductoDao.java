package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import aplicacion.Coordinador;
import aplicacion.JPAUtil;
import entidades.PersonasProductos;
import entidades.Producto;

public class ProductoDao {
	
	Coordinador miCoordinador;
	EntityManager entityManager=JPAUtil.getEntityManagerFactory().createEntityManager();
	
	public String registrarProducto(Producto miProducto) {
		String resp="";
	    try {
	    	entityManager.getTransaction().begin();
	        entityManager.persist (miProducto);
	        entityManager.getTransaction().commit();
	        resp="Producto Registrado!";
	        
	    }catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "No se puede registrar el Producto" + e,
	                   "ERROR", JOptionPane.ERROR_MESSAGE);
	    }
	    return resp;

	}

	public String registrarCompra(PersonasProductos producto) {
	    String resp="";
	    try {
	       entityManager.getTransaction(). begin();
	       entityManager.persist(producto);
	       entityManager.getTransaction().commit();
	       resp="Se realizó la compra del producto!";
	    }catch (Exception e) {
	       JOptionPane.showMessageDialog(null, "No se puede registrar" 
	                + "la compra del Producto",
	                "ERROR",JOptionPane.ERROR_MESSAGE ) ;
	    }
	    return resp;
	}
	
	public Producto consultarProducto(Long idProducto) {
		// TODO Auto-generated method stub
		Producto miProducto=entityManager.find(Producto.class, idProducto);
	   	if (miProducto!=null) {
	      return miProducto;
	   	}else {
	       return null;
	  	}
	}

	public List<Producto> consultarlistaProductos() {
		// TODO Auto-generated method stub
		List<Producto> listaProductos=new ArrayList<Producto>();
		Query query=entityManager.createQuery("SELECT p FROM Producto p");
		listaProductos= query.getResultList();
		return listaProductos;
	}

	public String actualizarProducto(Producto miProducto) {

		String resp="";
		try {
			
			entityManager.getTransaction().begin();
		    entityManager.merge (miProducto);
		    entityManager.getTransaction().commit();
		    resp="Producto Actualizada!";
		}catch (Exception e) {
		    JOptionPane.showMessageDialog (null, "No se puede actualizar "
		             + "el producto",
		            "ERROR", JOptionPane.ERROR_MESSAGE );
		}
		return resp;
	}

	public String eliminarProducto(Producto miProducto) {
		String resp="";
		try {
			entityManager.getTransaction().begin();
			   entityManager.remove(miProducto);
			   entityManager. getTransaction().commit();
			   resp="Producto Eliminada!";
		}catch(Exception e) {
			JOptionPane.showMessageDialog (null, "No se puede eliminar el producto"
		            +"",
		       "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return resp;
	}

	public void close() {
		
		entityManager.close();
		JPAUtil.shutdown ();
		
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador=miCoordinador;
	}



}