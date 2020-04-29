package spring.clasesDao;
import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import spring.interfacesDAO.MascotaDAO;
import spring.model.Mascota;
import spring.model.Veterinario;

@Repository
public class MascotaDAOHibernateJPA extends GenericDAOHibernateJPA<Mascota> implements MascotaDAO {

	
	public MascotaDAOHibernateJPA() {     
		super(Mascota.class);  
	}
	
	public List<Mascota> noAceptadas() {
		String value = "FALSE";
		return accept(value);
	}
	
	public List<Mascota> aceptadas() {
		String value = "TRUE";
		return accept(value);
	}
	
	public List<Mascota> accept(String value) {
		String condicion = "WHERE aceptada = ";
		String innerj = " ";
		return recuperarLista(innerj, (condicion+value) );
	}
	public List<Mascota> accept(String value,String value2) {
		String condicion = "WHERE aceptada = ";
		String innerj = " ";
		return recuperarLista( (innerj+value2) , (condicion+value) );
	}
	
	public List<Mascota> deVeterinario(String id) {
		String value1 = "TRUE";
		String value2 = "INNER JOIN USUARIO u ON e.VETERINARIO_ID = u.ID";
		return accept( (value2+id), value1);
	}
	
	public Mascota aceptarVet(Mascota mascota) {
		mascota.setAceptada(true);
		return actualizar(mascota);
	}
	
	public Mascota asignarVet(Mascota mascota, Veterinario vet) {
		mascota.setVeterinario(vet);
		return actualizar(mascota);
	}
	
	public List<Mascota> deDueno(int id) {
		return recuperarLista("","WHERE ID_DUENO = "+id);		
	}
	
}
