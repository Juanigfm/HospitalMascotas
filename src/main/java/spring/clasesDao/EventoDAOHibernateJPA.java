package spring.clasesDao;

import spring.interfacesDAO.EventoDAO;

public class EventoDAOHibernateJPA<T> extends GenericDAOHibernateJPA<T> implements EventoDAO<T> {
	
	public EventoDAOHibernateJPA(Class<T> clase) {     
		super(clase);  
	}
}
