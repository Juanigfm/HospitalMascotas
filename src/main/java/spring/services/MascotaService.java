package spring.services;

import spring.model.Veterinario;
import spring.model.Dueno;
import spring.model.Mascota;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import spring.clasesDTO.MascotaDTO;
import spring.interfacesDAO.MascotaDAO;
import org.springframework.stereotype.Service;

@Service
public class MascotaService
{
    @Autowired
    private MascotaDAO mascotaDAOHibernateJPA;
    @Autowired
    private VeterinarioService veterinarioService;
    @Autowired
    private DuenoService duenoService;
    
    public List<MascotaDTO> listAll() {
    	List<Mascota> mascotas = this.mascotaDAOHibernateJPA.recuperarTodos();
    	if (mascotas.size() == 0)
    		return null;
        return ConvertMascotasToDTO(mascotas);
    }
    
    public List<MascotaDTO> findAllMascotasDeDueno(final int id) {
    	List<Mascota> mascotas = this.mascotaDAOHibernateJPA.deDueno(id);
    	if (mascotas.size() == 0)
    		return null;
        return ConvertMascotasToDTO(mascotas);
    }
    
    @Transactional
    public MascotaDTO addMascota(final MascotaDTO mascotaDTO) {
    	
    	Mascota mascota = new Mascota(mascotaDTO); 
    	
        Veterinario vet = this.veterinarioService.loadByUsername(mascotaDTO.getVeterinarioUsername());
        Dueno due = this.duenoService.loadByUsername(mascotaDTO.getDuenoUsername());
        
        mascota.setDueno(due);
        if (vet != null)
        	mascota.setVeterinario(vet);
        
        Mascota masc = (Mascota)this.mascotaDAOHibernateJPA.persistir(mascota);
        masc = (Mascota)this.mascotaDAOHibernateJPA.actualizar(masc);
        
        return new MascotaDTO(masc);
    }
    
    private List<MascotaDTO> ConvertMascotasToDTO(List<Mascota> mascotas) {
    	List<MascotaDTO> mascotasDTO = new ArrayList<MascotaDTO>();
    	for (Mascota m : mascotas) {
    		mascotasDTO.add(new MascotaDTO(m));
    	}
    	return mascotasDTO;
    }
    
    private List<Mascota> ConvertDTOToMascota(List<MascotaDTO> mascotasDTO) {
    	List<Mascota> mascotas = new ArrayList<Mascota>();
    	for (MascotaDTO m : mascotasDTO) {
    		mascotas.add(new Mascota(m));
    	}
    	return mascotas;
    }

	public List<MascotaDTO> findAllMascotasDeDuenoByUsername(String username) {
        Dueno due = this.duenoService.loadByUsername(username);		
	    List<Mascota> mascotas = this.mascotaDAOHibernateJPA.deDueno(due.getId());
	    if (mascotas.size() == 0)
	    	return null;
	    return ConvertMascotasToDTO(mascotas);
	}
    
}