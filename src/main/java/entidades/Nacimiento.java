package entidades;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import aplicacion.Coordinador;

@Entity
@Table (name="nacimiento")
public class Nacimiento implements Serializable{
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_nacimiento")
	private Long idNacimiento;
	
	@Column (name = "fecha_nacimiento")
	private LocalDate fechaNacimeinto;
	
	@Column (name = "ciudad_nacimiento")
	private String ciudadNAcimiento;
	
	@Column (name = "departamento_nacimiento")
	private String departamentoNacimiento;
	
	@Column (name = "pais_nacimiento")
	private String paisNacimiento;
	
	@OneToOne(mappedBy = "nacimiento", fetch=FetchType.LAZY)
	private Persona persona;
	
	public Nacimiento() {
		
	}

	public Nacimiento(Long idNacimiento, LocalDate fechaNacimeinto, String ciudadNAcimiento,
			String departamentoNacimiento, String paisNacimiento) {
		super();
		this.idNacimiento = idNacimiento;
		this.fechaNacimeinto = fechaNacimeinto;
		this.ciudadNAcimiento = ciudadNAcimiento;
		this.departamentoNacimiento = departamentoNacimiento;
		this.paisNacimiento = paisNacimiento;
	}

	public Long getIdNacimiento() {
		return idNacimiento;
	}

	public void setIdNacimiento(Long idNacimiento) {
		this.idNacimiento = idNacimiento;
	}

	public LocalDate getFechaNacimeinto() {
		return fechaNacimeinto;
	}

	public void setFechaNacimeinto(LocalDate fechaNacimeinto) {
		this.fechaNacimeinto = fechaNacimeinto;
	}

	public String getCiudadNAcimiento() {
		return ciudadNAcimiento;
	}

	public void setCiudadNAcimiento(String ciudadNAcimiento) {
		this.ciudadNAcimiento = ciudadNAcimiento;
	}

	public String getDepartamentoNacimiento() {
		return departamentoNacimiento;
	}

	public void setDepartamentoNacimiento(String departamentoNacimiento) {
		this.departamentoNacimiento = departamentoNacimiento;
	}

	public String getPaisNacimiento() {
		return paisNacimiento;
	}

	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		String cade= "Nacimiento [idNacimiento=" + idNacimiento + ", fechaNacimeinto=" + fechaNacimeinto
				+ ", ciudadNAcimiento=" + ciudadNAcimiento + ", departamentoNacimiento=" + departamentoNacimiento
				+ ", paisNacimiento=" + paisNacimiento + "]";
		if(persona!=null) {
			cade+="PERSONA = "+persona.getIdPersona()+" - "+persona.getNombre();
		}
		return cade;
		
	}
	
	
}
