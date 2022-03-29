package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import aplicacion.Coordinador;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "id_producto")
    private Long idProducto;
    
    @Column (name = "nombre_producto", nullable = false, length = 45)
    private String nombreProducto;
    
    @Column (name = "precio_producto")
    private Double precioProducto;
    
    @ManyToMany (mappedBy = "listaProductos")
    private List<Persona> listaPersonas;
    
    public Producto() {
    	this.listaPersonas = new ArrayList<Persona>();
    	
    }
    
	public Producto(Long idProducto, String nombreProducto, Double precioProducto, List<Persona> listaPersonas) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.listaPersonas = listaPersonas;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public Double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public List<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	public ArrayList<String> iterarLista(List<Persona> listaPersonas){
		
		ArrayList<String> nombres = new ArrayList<String>();
		
		for(int i =0 ; i<listaPersonas.size(); i++) {
			nombres.add(listaPersonas.get(i).getNombre());
		}
		
		return nombres;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", precioProducto="
				+ precioProducto + ", listaPersonas=" + iterarLista(listaPersonas) + "]";
	}

   
}


