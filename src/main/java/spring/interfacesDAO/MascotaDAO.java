package spring.interfacesDAO;
import java.util.List;

import org.springframework.stereotype.Repository;

import spring.model.Mascota;
import spring.model.Veterinario;

@Repository
public interface MascotaDAO extends GenericDAO<Mascota> {
	
	public List<Mascota> aceptadas();
	public List<Mascota> noAceptadas();
	public List<Mascota> deVeterinario(String id);
	public Mascota aceptarVet(Mascota mascota);
	public Mascota asignarVet(Mascota mascota, Veterinario vet);
	public List<Mascota> deDueno(int i);
	
}
