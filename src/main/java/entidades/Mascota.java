package entidades;

import javax.persistence.*;
import javax.persistence.Table;

import aplicacion.Coordinador;

@Entity
@Table(name="mascotas")
public class Mascota {

	public static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_mascota")
	private Long idMascota;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "raza")
	private String raza;
	
	@Column(name = "color")
	private String colorMascota;
	
	@Column(name = "sexo")
	private String sexo;
	
	@ManyToOne
	@JoinColumn(name="persona_id", referencedColumnName= "id_persona")
	private Persona duenio;
	
	public Mascota() {
		
	}

	public Mascota(Long idMascota, String nombre, String raza, String colorMascota, String sexo, Persona duenio) {
		super();
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.raza = raza;
		this.colorMascota = colorMascota;
		this.sexo = sexo;
		this.duenio = duenio;
	}

	public Long getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Long idMascota) {
		this.idMascota = idMascota;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getColorMascota() {
		return colorMascota;
	}

	public void setColorMascota(String colorMascota) {
		this.colorMascota = colorMascota;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Persona getDuenio() {
		return duenio;
	}

	public void setDuenio(Persona duenio) {
		this.duenio = duenio;
	}

	@Override
	public String toString() {
		return "Mascota [idMascota=" + idMascota + ", nombre=" + nombre + ", raza=" + raza + ", colorMascota="
				+ colorMascota + ", sexo=" + sexo + ", duenio=" + duenio.getNombre() + "]";
	}


}
