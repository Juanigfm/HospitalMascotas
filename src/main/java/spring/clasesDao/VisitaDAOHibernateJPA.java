package spring.clasesDao;

import org.springframework.stereotype.Repository;

import spring.clasesDao.EventoDAOHibernateJPA;
import spring.interfacesDAO.VisitaDAO;
import spring.model.Visita;

@Repository
public class VisitaDAOHibernateJPA extends EventoDAOHibernateJPA<Visita> implements VisitaDAO {
	
	public VisitaDAOHibernateJPA() {
		super(Visita.class);
	}
}
