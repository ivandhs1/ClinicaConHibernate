package aplicacion;

import java.util.ArrayList;

import clases.GestionMascotas;
import clases.GestionPersonas;
import clases.GestionProductos;
import dao.*;
import entidades.*;
import gui.ActualizarMascotaGui;
import gui.ActualizarPersonaGui;
import gui.ActualizarProducto;
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

public class Coordinador {

	PersonaDao miPersonaDao;
	MascotaDao miMascotaDao;
	ProductoDao miProductoDao;
	JPAUtil miJPA;
	GestionMascotas miGestionMascotas;
	GestionPersonas miGestionPersonas;
	GestionProductos miGestionProductos;
	
	VentanaPrincipal miVentanaPrincipal;
	RegistrarPersonasGui miRegistrarPersonasGui;
	ConsultarPersonaGui miConsultarPersonasGui;
	ListarPersonas miListarPersonasGui;
	ActualizarPersonaGui miActualizarPersonasGui;
	EliminarPersonaGui miEliminarPersonasGui;
	
	RegistrarMascotasGui miRegistrarMascotasGui;
	ConsultarMascotaGui miConsultarMascotaGui;
	ListarMascotasGui miListarMascotasGui;
	ActualizarMascotaGui miActualizarMascotas;
	EliminarMascotaGui miEliminarMascotaGui;
	
	RegistrarProductosGui miRegistrarProductosGui;
	ConsultarProductoGui miConsultarProductosGui;
	ListarProductos miListarProductosGui;
	ActualizarProducto miActualizarProductoGui;
	EliminarProducto miEliminarProductosGui;

	
	public void setJPA(JPAUtil miJPA) {
		// TODO Auto-generated method stub
		this.miJPA = miJPA;
	}

	public void setGestionPersonas(GestionPersonas miGestionPersonas) {
		// TODO Auto-generated method stub
		this.miGestionPersonas = miGestionPersonas;
	}

	public void setGestionMascotas(GestionMascotas miGestionMascotas) {
		// TODO Auto-generated method stub
		this.miGestionMascotas = miGestionMascotas;
	}

	public void setGestionProductos(GestionProductos miGestionProductos) {
		// TODO Auto-generated method stub
		this.miGestionProductos = miGestionProductos;
	}

	public void setMascotaDao(MascotaDao miMascotaDao) {
		// TODO Auto-generated method stub
		this.miMascotaDao = miMascotaDao;
	}


	public void setPersonaDao(PersonaDao miPersonaDao) {
		// TODO Auto-generated method stub
		this.miPersonaDao = miPersonaDao;
	}


	public void setProductoDao(ProductoDao miProductoDao) {
		// TODO Auto-generated method stub
		this.miProductoDao = miProductoDao;
	}

	public void setVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		// TODO Auto-generated method stub
		this.miVentanaPrincipal = miVentanaPrincipal;
	}

	public void setRegistrarPersonasGui(RegistrarPersonasGui miRegistrarPersonasGui) {
		// TODO Auto-generated method stub
		this.miRegistrarPersonasGui = miRegistrarPersonasGui;
	}

	public void setConsultarPersonaGui(ConsultarPersonaGui miConsultarPersonasGui) {
		// TODO Auto-generated method stub
		this.miConsultarPersonasGui = miConsultarPersonasGui;
	}

	public void setListarPersonasGui(ListarPersonas miListarPersonasGui) {
		// TODO Auto-generated method stub
		this.miListarPersonasGui = miListarPersonasGui;
	}

	public void setActualizarPersonasGui(ActualizarPersonaGui miActualizarPersonasGui) {
		// TODO Auto-generated method stub
		this.miActualizarPersonasGui = miActualizarPersonasGui;
	}

	public void setEliminarPersonasGui(EliminarPersonaGui miEliminarPersonasGui) {
		// TODO Auto-generated method stub
		this.miEliminarPersonasGui = miEliminarPersonasGui;
	}

	public void setRegistrarMascotasGui(RegistrarMascotasGui miRegistrarMascotasGui) {
		// TODO Auto-generated method stub
		this.miRegistrarMascotasGui = miRegistrarMascotasGui;
	}
	
	public void setConsultarMascotasGui(ConsultarMascotaGui miConsultarMascotasGui) {
		// TODO Auto-generated method stub
		this.miConsultarMascotaGui = miConsultarMascotasGui;
	}

	public void setListarMascotasGui(ListarMascotasGui miListarMascotasGui) {
		// TODO Auto-generated method stub
		this.miListarMascotasGui = miListarMascotasGui;
	}

	public void setActualizarMascotasGui(ActualizarMascotaGui miActualizarMascotasGui) {
		// TODO Auto-generated method stub
		this.miActualizarMascotas = miActualizarMascotasGui;
	}

	public void setEliminarMascotasGui(EliminarMascotaGui miEliminarMascotasGui) {
		// TODO Auto-generated method stub
		this.miEliminarMascotaGui = miEliminarMascotasGui;
	}

	public void setRegistrarProductosGui(RegistrarProductosGui miRegistrarProductoGui) {
		// TODO Auto-generated method stub
		this.miRegistrarProductosGui = miRegistrarProductosGui;
	}

	public void setConsultarProductosGui(ConsultarProductoGui miConsultarProductoGui) {
		// TODO Auto-generated method stub
		this.miConsultarProductosGui = miConsultarProductoGui;
	}

	public void setListarProductosGui(ListarProductos miListarProductosGui) {
		// TODO Auto-generated method stub
		this.miListarProductosGui = miListarProductosGui;
	}

	public void setActualizarProductosGui(ActualizarProducto miActualizarProductosGui) {
		// TODO Auto-generated method stub
		this.miActualizarProductoGui = miActualizarProductosGui;
	}

	public void setEliminarProductosGui(EliminarProducto miEliminarProductoGui) {
		// TODO Auto-generated method stub
		this.miEliminarProductosGui = miEliminarProductoGui;
	}

	public void mostrarVentanaRegistroMascotas(long parseLong) {
		// TODO Auto-generated method stub
		this.miRegistrarMascotasGui.setVisible(true);
	}

	public String registrarPersona(Persona miPersona) {
		// TODO Auto-generated method stub
		return miPersonaDao.registrarPersona(miPersona);
	}

	public void mostrarVentanaRegistroPersonas() {
		// TODO Auto-generated method stub
		miRegistrarPersonasGui.setVisible(true);
	}

	
	public Persona consultarPersona(Long idPersona) {
		
		return miPersonaDao.consultarPersona(idPersona);
	}


}