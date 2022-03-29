package aplicacion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	Coordinador miCoordinador;
	
	private static final String UNIDAD_DE_PERSISTENCIA="PruebaHibernateLaboratorio";
	private static EntityManagerFactory factory;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(factory==null) {
			factory=Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA);
		}
		return factory;
	}
	
	public static void shutdown() {
		if(factory!=null) {
			factory.close();
			factory=null;
		}	
	}

	public void setCoordinador(Coordinador miCoordinador) {
		// TODO Auto-generated method stub
		this.miCoordinador = miCoordinador;
	}
}
