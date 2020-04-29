package spring.clasesDao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import spring.interfacesDAO.EnfermedadDAO;
import spring.model.Enfermedad;

@Repository
public class EnfermedadDAOHibernateJPA extends EventoDAOHibernateJPA<Enfermedad> implements EnfermedadDAO {

	public EnfermedadDAOHibernateJPA() {
		super(Enfermedad.class);
	}
	

}
