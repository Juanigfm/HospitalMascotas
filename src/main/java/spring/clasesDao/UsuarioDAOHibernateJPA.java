package spring.clasesDao;

import java.util.HashMap;
import java.util.List;

import spring.interfacesDAO.UsuarioDAO;

//@Repository
public class UsuarioDAOHibernateJPA<T> extends GenericDAOHibernateJPA<T> implements UsuarioDAO<T> {

	public UsuarioDAOHibernateJPA(Class<T> clase) {     
		super(clase);  
	}
	
}
