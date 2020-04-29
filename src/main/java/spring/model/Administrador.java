package spring.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import spring.clasesDTO.UsuarioDTO;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Usuario {
	
    public Administrador(final String nombre, final String apellido, final String telefono, final String email) {
        super(nombre, apellido, telefono, email);
    }
    
    public Administrador() {
    }
    
    public String toString() {
        return "Administrador [getNombre()=" + this.getNombre() + ", getApellido()=" + this.getApellido() + ", getTelefono()=" + this.getTelefono() + ", getEmail()=" + this.getEmail() + ", getId()=" + this.getId() + "]";
    }
    
    public Administrador(UsuarioDTO admin) {
    	setUsername(admin.getUsername());
    	setNombre(admin.getNombre());
    	setApellido(admin.getApellido());
    	setTelefono(admin.getTelefono());
    	setEmail(admin.getEmail());
    	setPassword(admin.getPassword());
    }
}