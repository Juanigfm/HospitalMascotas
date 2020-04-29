package spring.clasesDao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import spring.interfacesDAO.DesparacitacionDAO;
import spring.model.Desparacitacion;
import spring.model.Dueno;
import spring.model.Evento;

@Repository
public class DesparacitacionDAOHibernateJPA extends EventoDAOHibernateJPA<Desparacitacion> implements DesparacitacionDAO {

	public DesparacitacionDAOHibernateJPA() {     
		super(Desparacitacion.class);  
	}

}
