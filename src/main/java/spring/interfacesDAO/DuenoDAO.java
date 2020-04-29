package spring.interfacesDAO;

import java.util.List;

import spring.clasesDTO.UsuarioDTO;
import spring.model.Dueno;

public interface DuenoDAO extends UsuarioDAO<Dueno> {

	List<Dueno> recuperarDatos(Dueno dueno);

	List<Dueno> recuperarPorUsername(String duenoUsername);


}
