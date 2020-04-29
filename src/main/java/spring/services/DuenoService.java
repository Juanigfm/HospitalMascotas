package spring.services;

import java.io.Serializable;
import spring.model.Dueno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import spring.clasesDTO.UsuarioDTO;
import spring.interfacesDAO.DuenoDAO;
import org.springframework.stereotype.Service;

@Service
public class DuenoService
{
    @Autowired
    private DuenoDAO DuenoDAOHibernateJPA;
    
    public List<Dueno> listAll() {
        return (List<Dueno>)this.DuenoDAOHibernateJPA.recuperarTodos();
    }
    
    public Dueno addDueno(final Dueno Dueno) {
        return (Dueno)this.DuenoDAOHibernateJPA.persistir(Dueno);
    }
    
    public Dueno loadById(final int id) {
        return (Dueno)this.DuenoDAOHibernateJPA.recuperar(id);
    }
    
    @Autowired
    public DuenoService(final DuenoDAO VDAO) {
    }
    
    public DuenoService() {
    }

	public Dueno loadByUsername(String duenoUsername) {
		// TODO Auto-generated method stub
		return this.DuenoDAOHibernateJPA.recuperarPorUsername(duenoUsername).get(0);
	}

}