package spring.clasesDao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import spring.clasesDTO.UsuarioDTO;
import spring.interfacesDAO.VeterinarioDAO;
import spring.model.*;

@Repository
public class VeterinarioDAOHibernateJPA extends UsuarioDAOHibernateJPA<Veterinario> implements VeterinarioDAO {

	public VeterinarioDAOHibernateJPA() {     
		super(Veterinario.class);  
	}
	
	public List<Veterinario> recuperarNoAceptados() { 
		String condicion = "WHERE ACEPTADO = FALSE ";
		String innerj = " ";
		return recuperarLista(condicion,innerj);
	}
	
	public List<Veterinario> recuperarAceptados() { 
		String condicion = "WHERE ACEPTADO = TRUE ";
		String innerj = " ";
		return recuperarLista(condicion,innerj);
	}
	
	public List<Veterinario> login(Veterinario user){
		return recuperarLista("","WHERE e.username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'");
	}
	
	public List<Veterinario> recuperarDatos(Veterinario v) {
		return recuperarLista("","WHERE e.username = '" + v.getUsername() + "'");
	}
	
	public List<Veterinario> recuperarPorUsername(String veterinarioUsername) {
		return recuperarLista("","WHERE e.username = '" + veterinarioUsername + "'");
	}

	@Override
	public List<Veterinario> allVeterinarios() {
		return recuperarTodos();
	}
}
