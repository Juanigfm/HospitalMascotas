package spring.clasesDao;

import org.springframework.stereotype.Repository;

import spring.interfacesDAO.VacunacionDAO;
import spring.model.Vacunacion;

@Repository
public class VacunacionDAOHibernateJPA extends EventoDAOHibernateJPA<Vacunacion> implements VacunacionDAO {
	
	public VacunacionDAOHibernateJPA() {
		super(Vacunacion.class);
	}
}
