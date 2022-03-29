package aplicacion;

import clases.GestionMascotas;
import clases.GestionPersonas;
import clases.GestionProductos;
import dao.MascotaDao;
import dao.PersonaDao;
import dao.ProductoDao;
import entidades.*;
import gui.ActualizarMascotaGui;
import gui.ActualizarPersonaGui;
import gui.ActualizarProducto;
import gui.ComprarProductoGui;
import gui.ConsultarMascotaGui;
import gui.ConsultarPersonaGui;
import gui.ConsultarProductoGui;
import gui.EliminarMascotaGui;
import gui.EliminarPersonaGui;
import gui.EliminarProducto;
import gui.ListarMascotasGui;
import gui.ListarPersonas;
import gui.ListarProductos;
import gui.RegistrarMascotasGui;
import gui.RegistrarPersonasGui;
import gui.RegistrarProductosGui;
import gui.VentanaPrincipal;

public class Relaciones {

	public Relaciones() {

		// se declaran las clases que van a representar instancias unicas

		Coordinador miCoordinador = new Coordinador();
		JPAUtil miJPA = new JPAUtil();
		GestionPersonas miGestionPersonas = new GestionPersonas();
		GestionMascotas miGestionMascotas = new GestionMascotas();
		GestionProductos miGestionProductos = new GestionProductos();
		MascotaDao miMascotaDao = new MascotaDao();
		PersonaDao miPersonaDao = new PersonaDao();
		ProductoDao miProductoDao = new ProductoDao();

		
		VentanaPrincipal miVentanaPrincipal = new VentanaPrincipal();
		
		RegistrarPersonasGui miRegistrarPersonasGui = new RegistrarPersonasGui(miVentanaPrincipal, false);
		ConsultarPersonaGui miConsultarPersonasGui = new ConsultarPersonaGui(miVentanaPrincipal, false);
		ListarPersonas miListarPersonasGui = new ListarPersonas();
		ActualizarPersonaGui miActualizarPersonasGui = new ActualizarPersonaGui(miVentanaPrincipal, false);
		EliminarPersonaGui miEliminarPersonasGui = new EliminarPersonaGui(miVentanaPrincipal, false);
		
		RegistrarMascotasGui miRegistrarMascotasGui = new RegistrarMascotasGui(miVentanaPrincipal, false, null);
		ConsultarMascotaGui miConsultarMascotasGui = new ConsultarMascotaGui(miVentanaPrincipal, false);
		ListarMascotasGui miListarMascotasGui = new ListarMascotasGui();
		ActualizarMascotaGui miActualizarMascotasGui = new ActualizarMascotaGui(miVentanaPrincipal, false);
		EliminarMascotaGui miEliminarMascotasGui = new EliminarMascotaGui(miVentanaPrincipal, false);
		
		RegistrarProductosGui miRegistrarProductoGui = new RegistrarProductosGui(miVentanaPrincipal, false);
		ConsultarProductoGui miConsultarProductoGui = new ConsultarProductoGui(miVentanaPrincipal, false);
		ListarProductos miListarProductosGui = new ListarProductos();
		ActualizarProducto miActualizarProductosGui = new ActualizarProducto(miVentanaPrincipal, false);
		EliminarProducto miEliminarProductoGui = new EliminarProducto(miVentanaPrincipal, false);
		ComprarProductoGui miComprarProductosGui = new ComprarProductoGui(miVentanaPrincipal, false);
		

		// Se establece la relacion entre el coordinador y cada instancia unica
		
		miCoordinador.setJPA(miJPA);
		miCoordinador.setGestionPersonas(miGestionPersonas);
		miCoordinador.setGestionMascotas(miGestionMascotas);
		miCoordinador.setGestionProductos(miGestionProductos);
		miCoordinador.setMascotaDao(miMascotaDao);
		miCoordinador.setPersonaDao(miPersonaDao);
		miCoordinador.setProductoDao(miProductoDao);
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setConsultarPersonaGui(miConsultarPersonasGui);
		miCoordinador.setListarPersonasGui(miListarPersonasGui);
		miCoordinador.setActualizarPersonasGui(miActualizarPersonasGui);
		miCoordinador.setEliminarPersonasGui(miEliminarPersonasGui);
		
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setConsultarMascotasGui(miConsultarMascotasGui);
		miCoordinador.setListarMascotasGui(miListarMascotasGui);
		miCoordinador.setActualizarMascotasGui(miActualizarMascotasGui);
		miCoordinador.setEliminarMascotasGui(miEliminarMascotasGui);
		
		miCoordinador.setRegistrarProductosGui(miRegistrarProductoGui);
		miCoordinador.setConsultarProductosGui(miConsultarProductoGui);
		miCoordinador.setListarProductosGui(miListarProductosGui);
		miCoordinador.setActualizarProductosGui(miActualizarProductosGui);
		miCoordinador.setEliminarProductosGui(miEliminarProductoGui);
		miCoordinador.setComprarProductosGui(miComprarProductosGui);
	
		
		
		// al coordinador se le asigna el control de cada clase unica
		
		miJPA.setCoordinador(miCoordinador);
		miGestionPersonas.setCoordinador(miCoordinador);
		miGestionMascotas.setCoordinador(miCoordinador);
		miGestionProductos.setCoordinador(miCoordinador);
		miPersonaDao.setCoordinador(miCoordinador);
		miMascotaDao.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);

		miVentanaPrincipal.setCoordinador(miCoordinador);
		
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miConsultarPersonasGui.setCoordinador(miCoordinador);
		miListarPersonasGui.setCoordinador(miCoordinador);
		miActualizarPersonasGui.setCoordinador(miCoordinador);
		miEliminarPersonasGui.setCoordinador(miCoordinador);
		
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miConsultarMascotasGui.setCoordinador(miCoordinador);
		miListarMascotasGui.setCoordinador(miCoordinador);
		miActualizarMascotasGui.setCoordinador(miCoordinador);
		miEliminarMascotasGui.setCoordinador(miCoordinador);
		
		miRegistrarProductoGui.setCoordinador(miCoordinador);
		miConsultarProductoGui.setCoordinador(miCoordinador);
		miListarProductosGui.setCoordinador(miCoordinador);
		miActualizarProductosGui.setCoordinador(miCoordinador);
		miEliminarProductoGui.setCoordinador(miCoordinador);
		
		
		miVentanaPrincipal.setVisible(true);


	}

}
