package spring.interfacesDAO;

import java.util.List;

import spring.clasesDTO.UsuarioDTO;
import spring.model.Dueno;
import spring.model.Veterinario;

public interface VeterinarioDAO extends UsuarioDAO<Veterinario> {

	public List<Veterinario> recuperarNoAceptados();
	public List<Veterinario> recuperarAceptados();
	public List<Veterinario> recuperarDatos(Veterinario v);
	public List<Veterinario> allVeterinarios();
	public List<Veterinario> recuperarPorUsername(String veterinarioUsername);

}
