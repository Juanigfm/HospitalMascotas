package spring.clasesDao;

import org.springframework.stereotype.Repository;

import spring.interfacesDAO.IntervencionQuirurgicaDAO;
import spring.model.IntervencionQuirurgica;

@Repository
public class IntervencionQuirurgicaDAOHibernateJPA extends EventoDAOHibernateJPA<IntervencionQuirurgica> implements IntervencionQuirurgicaDAO {

	public IntervencionQuirurgicaDAOHibernateJPA() {
		super(IntervencionQuirurgica.class);
	}
}
