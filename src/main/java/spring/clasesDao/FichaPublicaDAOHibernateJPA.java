package spring.clasesDao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import spring.interfacesDAO.FichaPublicaDAO;
import spring.model.FichaPublica;

@Repository
public class FichaPublicaDAOHibernateJPA extends GenericDAOHibernateJPA<FichaPublica> implements FichaPublicaDAO {

	public FichaPublicaDAOHibernateJPA() {
		super(FichaPublica.class);
	}
}
