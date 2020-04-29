package spring.clasesDao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import spring.interfacesDAO.AdministradorDAO;
import spring.interfacesDAO.UsuarioDAO;
import spring.model.Administrador;
import spring.model.Dueno;

@Repository
public class AdministradorDAOHibernateJPA extends UsuarioDAOHibernateJPA<Administrador> implements AdministradorDAO {

	public AdministradorDAOHibernateJPA() {     
		super(Administrador.class);  
	}
	
	public List<Administrador> login(Administrador user){
		return recuperarLista("","WHERE e.username = '" + user.getUsername() + "' and password = '" + user.getPassword() + "'");
	}
}
