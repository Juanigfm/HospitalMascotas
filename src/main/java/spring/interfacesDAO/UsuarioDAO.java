package spring.interfacesDAO;

import spring.model.Usuario;

import java.util.HashMap;
import java.util.List;

public interface UsuarioDAO<T> extends GenericDAO<T> {
	
	public List<T> login(T user);

}
