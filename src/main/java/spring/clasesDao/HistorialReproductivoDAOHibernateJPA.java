package spring.clasesDao;

import org.springframework.stereotype.Repository;

import spring.interfacesDAO.HistorialReproductivoDAO;
import spring.model.HistorialReproductivo;

@Repository
public class HistorialReproductivoDAOHibernateJPA extends EventoDAOHibernateJPA<HistorialReproductivo> implements HistorialReproductivoDAO {
	
	public HistorialReproductivoDAOHibernateJPA() {
		super(HistorialReproductivo.class);
	}
}
