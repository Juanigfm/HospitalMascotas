package spring.clasesDao;

import java.util.List;

import org.springframework.stereotype.Repository;

import spring.clasesDTO.UsuarioDTO;
import spring.interfacesDAO.DuenoDAO;
import spring.model.Administrador;
import spring.model.Dueno;

@Repository
public class DuenoDAOHibernateJPA extends UsuarioDAOHibernateJPA<Dueno> implements DuenoDAO {
	
    public DuenoDAOHibernateJPA() {
        super(Dueno.class);
    }
    
	public List<Dueno> login(Dueno user){
		return recuperarLista("","WHERE e.username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'");
	}

	public List<Dueno> recuperarDatos(Dueno d) {
		return recuperarLista("","WHERE e.username = '" + d.getUsername() + "'");
	}

	public List<Dueno> recuperarPorUsername(String duenoUsername) {
		return recuperarLista("","WHERE e.username = '" + duenoUsername + "'");
	}
}