package spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import spring.clasesDTO.DuenoDTO;
import spring.clasesDTO.UsuarioDTO;
import spring.interfacesDAO.AdministradorDAO;
import spring.interfacesDAO.DuenoDAO;
import spring.interfacesDAO.VeterinarioDAO;
import spring.model.Administrador;
import spring.model.Dueno;
import spring.model.Veterinario;

import java.util.HashMap;
import java.util.List;

@Service
public class UsuarioService {

	@Autowired
	private AdministradorDAO adminDao;
	@Autowired
	private DuenoDAO duenoDao;
	@Autowired
	private VeterinarioDAO vetDao;
    @Autowired
    private VeterinarioService veterinarioService;

	public UsuarioDTO loginDuenio(UsuarioDTO user) {
		Dueno d = new Dueno(user);
		List<Dueno> duenos = duenoDao.login(d);
		if (duenos.size() == 0)
			return null;
		UsuarioDTO usu = new UsuarioDTO(duenos.get(0));
		return usu;
	}
	
	public UsuarioDTO loginAdministrador(UsuarioDTO user) {
		Administrador a = new Administrador(user);
		List<Administrador> admins = adminDao.login(a);
		if (admins.size() == 0)
			return null;
		UsuarioDTO usu = new UsuarioDTO(admins.get(0));
		return usu;
	}
	
	public UsuarioDTO loginVeterinario(UsuarioDTO user) {
		Veterinario v = new Veterinario(user);
		List<Veterinario> vets = vetDao.login(v);
		if (vets.size() == 0)
			return null;
		UsuarioDTO usu = new UsuarioDTO(vets.get(0));
		return usu;
	}

	public UsuarioDTO createVeterinario(UsuarioDTO user) {
		Veterinario v = new Veterinario(user);
		Veterinario vet = vetDao.persistir(v);
		UsuarioDTO usu = new UsuarioDTO(vet);
		return usu;
	}

	public UsuarioDTO createDueno(UsuarioDTO user) {
		Dueno d = new Dueno(user);
		Dueno dueno = duenoDao.persistir(d);
		UsuarioDTO usu = new UsuarioDTO(dueno);
		return usu;
	}

	public UsuarioDTO dataDueno(String username) {
		Dueno d = new Dueno();
		d.setUsername(username);
		List<Dueno> duenos = duenoDao.recuperarDatos(d);
		if (duenos.size() == 0)
			return null;
		UsuarioDTO usu = new UsuarioDTO(duenos.get(0));
		return usu;	
	}
	
	public UsuarioDTO dataVeterinario(String username) {
		Veterinario v = new Veterinario();
		v.setUsername(username);
		List<Veterinario> vets = vetDao.recuperarDatos(v);
		if (vets.size() == 0)
			return null;
		UsuarioDTO usu = new UsuarioDTO(vets.get(0));
		return usu;	
	}

	public UsuarioDTO updateDueno(UsuarioDTO user) {
		Dueno d = new Dueno(user);
		List<Dueno> duenos = duenoDao.recuperarDatos(d);
		if (duenos.size() == 0)
			return null;
		duenos.get(0).actualizar(d);
		d = duenoDao.actualizar(duenos.get(0));
		UsuarioDTO usu = new UsuarioDTO(d);
		return usu;
	}
	
	public UsuarioDTO updateVeterinario(UsuarioDTO user) {
		Veterinario v = new Veterinario(user);
		List<Veterinario> vets = vetDao.recuperarDatos(v);
		if (vets.size() == 0)
			return null;
		vets.get(0).actualizar(v);
		v = vetDao.actualizar(vets.get(0));
		UsuarioDTO usu = new UsuarioDTO(v);
		return usu;
	}

	public List<UsuarioDTO> allVeterinarios() {
		return veterinarioService.allVeterinarios();
	}
			
}
