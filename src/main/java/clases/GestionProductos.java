package clases;

import java.util.List;

import javax.swing.JOptionPane;

import aplicacion.Coordinador;
import dao.PersonaDao;
import dao.ProductoDao;
import entidades.Persona;
import entidades.PersonasProductos;
import entidades.Producto;

public class GestionProductos {
	
    ProductoDao miProductoDao = new ProductoDao();
    Coordinador miCoordinador;

	private void registrar() {
		// TODO Auto-generated method stubç
		Producto miProducto = new Producto();
		miProducto.setIdProducto(null);
		miProducto.setNombreProducto(JOptionPane.
	            showInputDialog("Ingrese el nombre del producto"));
		miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto")));
	    System.out.println(miProductoDao.registrarProducto(miProducto));
		
	}
	
	private void consultar() {
		Long idProducto = Long.parseLong(JOptionPane.
	            showInputDialog("Ingrese el id del producto"));
	    Producto miproducto = miProductoDao.consultarProducto(idProducto);
	    if (miproducto != null) {
	        System.out.println(miproducto);
	        System.out.println();
	    } else {
	        System.out.println();
	        System.out.println("No se encontr� el producto");
	    }
	    System.out.println();
	}
	
	private void consultarlista() {
		// TODO Auto-generated method stub
		System.out.println("Lista de Productos");
	    List<Producto> listaProductos = miProductoDao.consultarlistaProductos();
	    for (Producto producto : listaProductos) {
	    	
	        System.out.println(producto.toString());
	    }
	}
	private void comprarProductos() {
		// TODO Auto-generated method stub
		PersonasProductos producto;
		
		Persona miPersona;
		Producto miProducto;
		
		Long personaId;
		Long productoId;
		int opc=0;
		do {
			miProducto = new Producto();
			producto=new PersonasProductos ();
		    personaId=Long.parseLong (JOptionPane.showInputDialog("Ingrese"
		          + " el documento de la persona"));
		    productoId=Long.parseLong(JOptionPane.showInputDialog("Ingrese "
		            + "el codigo del producto"));
		    producto.setPersonaId(personaId);
		    producto.setProductoId(productoId);

		    miProducto=miProductoDao.consultarProducto(productoId);
		    miPersona= new PersonaDao().consultarPersona(personaId);
		    miProducto.getListaPersonas().add(miPersona);
		    
		    System.out.println(miProductoDao.registrarCompra(producto));
		    System.out.println();
		    opc=Integer.parseInt (JOptionPane.showInputDialog ("Ingrese 1 si "
		            + "desea agregar otro producto"));
		    
		} while (opc==1);
		
	}
	private void actualizar() {
		// TODO Auto-generated method stub
		Long idProducto = Long.parseLong(JOptionPane.showInputDialog("Ingrese el id del producto para actualizar"));
	    Producto miProducto = miProductoDao.consultarProducto(idProducto);
	    if (miProducto != null) {
	        System.out.println(miProducto);
	        System.out.println();
	        miProducto.setNombreProducto(JOptionPane.
		            showInputDialog("Ingrese el nombre del producto"));
			miProducto.setPrecioProducto(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto")));
		    
			
	        System.out.println(miProductoDao.actualizarProducto(miProducto));
	        System.out.println();
	     } else {
	        System.out.println();
	        System.out.println("No se encontr� la mascota");
	     }
	    System.out.println();
	}
	private void eliminar() {
		// TODO Auto-generated method stub
		Long idProducto = Long.parseLong (JOptionPane.
                showInputDialog("Ingrese el id del producto para eliminar"));
		Producto miProducto = miProductoDao.consultarProducto(idProducto);
        if (miProducto != null) {
        	System.out.println(miProducto);
            System.out.println();
            System.out.println(miProductoDao.eliminarProducto(miProducto));
            System.out.println();
        } else {
            System.out.println("No se encontr� el producto");
        }
        System.out.println();
	}
	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
}
