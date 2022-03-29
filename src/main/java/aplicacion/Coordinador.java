package aplicacion;

import java.util.ArrayList;
import java.util.List;

import clases.GestionMascotas;
import clases.GestionPersonas;
import clases.GestionProductos;
import dao.*;
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
	ComprarProductoGui miComprarProductosGui;

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
		this.miRegistrarProductosGui = miRegistrarProductoGui;
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

	public void mostrarVentanaRegistroProducto() {
		// TODO Auto-generated method stub
		miRegistrarProductosGui.setVisible(true);
		miRegistrarProductosGui.limpiar();
	}

	public void mostrarVentanaConsultarProductos() {
		// TODO Auto-generated method stub
		miConsultarProductosGui.setVisible(true);
		miConsultarProductosGui.limpiar();
	}

	public void mostrarVentanaActualizarProducto() {
		// TODO Auto-generated method stub
		miActualizarProductoGui.setVisible(true);
		miActualizarProductoGui.vaciar();
	}

	public void mostrarVentanaEliminarProductos() {
		// TODO Auto-generated method stub
		miEliminarProductosGui.setVisible(true);
	}

	public String registrarProducto(Producto miProducto) {
		// TODO Auto-generated method stub
		return miProductoDao.registrarProducto(miProducto);
	}

	public Producto consultarProducto(Long idProducto) {
		// TODO Auto-generated method stub
		return miProductoDao.consultarProducto(idProducto);
	}

	public String actualizarProducto(Producto miProducto) {
		// TODO Auto-generated method stub
		return miProductoDao.actualizarProducto(miProducto);
	}

	public String eliminarProducto(Producto miProducto) {
		// TODO Auto-generated method stub
		return miProductoDao.eliminarProducto(miProducto);
	}

	public void setComprarProductosGui(ComprarProductoGui miComprarProductosGui) {
		// TODO Auto-generated method stub
		this.miComprarProductosGui = miComprarProductosGui;
	}

	public void mostrarVentanaComprarProductos() {
		// TODO Auto-generated method stub
		miComprarProductosGui.setVisible(true);
	}

	public Persona consultarPersona(Long idPersona) {

		return miPersonaDao.consultarPersona(idPersona);
	}

	public void mostrarVentanaConsultarPersonas() {
		miConsultarPersonasGui.setVisible(true);
		
	}

	public String registrarMascota(Mascota miMascota) {
		return miMascotaDao.registrarMascota(miMascota);
	}

	public void mostrarVentanaRegistroMascotas() {
		miRegistrarMascotasGui.setVisible(true);
		
	}

	public Mascota consultarMascota(Long idMascota) {
		return miMascotaDao.consultarMascota(idMascota);
	}

	public void mostrarVentanaConsultarMascotas() {
		miConsultarMascotaGui.setVisible(true);
		
	}

	public List<Mascota> consultarListaMascotas() {
		return miMascotaDao.consultarListaMascotas();
	}

	public void mostrarVentanaListarMascotas() {
		miListarMascotasGui.setVisible(true);
		miListarMascotasGui.llenar();
		
	}

	public String actualizarMascota(Mascota miMascota) {

		return miMascotaDao.actualizarMascota(miMascota);
	}

	public void mostrarVentanaActualizarMascota() {
		miActualizarMascotas.setVisible(true);
		
	}
	
	

	public String eliminarMascota(Mascota miMascota) {
		// TODO Auto-generated method stub
		return miMascotaDao.eliminarMascota(miMascota);
	}

}