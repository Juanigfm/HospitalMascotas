package spring.clasesDao;

import org.springframework.stereotype.Repository;

import spring.interfacesDAO.RecordatorioDAO;
import spring.model.Recordatorio;

@Repository
public class RecordatorioDAOHibernateJPA extends GenericDAOHibernateJPA<Recordatorio> implements RecordatorioDAO {
	
	public RecordatorioDAOHibernateJPA() {
		super(Recordatorio.class);
	}
}
