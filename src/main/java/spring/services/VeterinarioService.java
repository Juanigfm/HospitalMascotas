package spring.services;

import java.io.Serializable;
import spring.model.Veterinario;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import spring.clasesDTO.UsuarioDTO;
import spring.interfacesDAO.VeterinarioDAO;
import org.springframework.stereotype.Service;

@Service
public class VeterinarioService
{
    @Autowired
    private VeterinarioDAO veterinarioDAOHibernateJPA;
    
    public List<Veterinario> listAll() {
        return (List<Veterinario>)this.veterinarioDAOHibernateJPA.recuperarTodos();
    }
    
    public Veterinario addVeterinario(final Veterinario veterinario) {
        return (Veterinario)this.veterinarioDAOHibernateJPA.persistir(veterinario);
    }
    
    public Veterinario loadById(final int id) {
        return (Veterinario)this.veterinarioDAOHibernateJPA.recuperar((Serializable)id);
    }
    
    public Veterinario loadByUsername(final String username) {
    	List<Veterinario> vets = (List<Veterinario>)this.veterinarioDAOHibernateJPA.recuperarPorUsername(username);
    	if(vets!= null && vets.size() > 0)
    		return (Veterinario)this.veterinarioDAOHibernateJPA.recuperarPorUsername(username).get(0);
    	return null;
    }
    
    @Autowired
    public VeterinarioService(final VeterinarioDAO VDAO) {
    }
    
    public VeterinarioService() {
    }

	public List<UsuarioDTO> allVeterinarios() {
		List<Veterinario> vets = this.veterinarioDAOHibernateJPA.allVeterinarios();
		List<UsuarioDTO> usuarios = new ArrayList();
		for (int i=0; i<vets.size(); i++)
			usuarios.add(new UsuarioDTO(vets.get(i)));
		return usuarios;
	}
}