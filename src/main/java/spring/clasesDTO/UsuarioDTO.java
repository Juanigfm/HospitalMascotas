package spring.clasesDTO;

import javax.persistence.Column;

import spring.model.Administrador;
import spring.model.Dueno;
import spring.model.Veterinario;

public class UsuarioDTO {
	
	private String username;
   
    private String password;

    private String nombre;
    
    private String apellido;
    
    private String telefono;
    
    private String email;
    
    private String tipo;
    
	private String nombreConsultorio;
    
    private String domicilioConsultorio;
    
    private boolean aceptado;
    
    public String getNombreConsultorio() {
		return nombreConsultorio;
	}
	public void setNombreConsultorio(String nombreConsultorio) {
		this.nombreConsultorio = nombreConsultorio;
	}
	public String getDomicilioConsultorio() {
		return domicilioConsultorio;
	}
	public void setDomicilioConsultorio(String domicilioConsultorio) {
		this.domicilioConsultorio = domicilioConsultorio;
	}
	public boolean isAceptado() {
		return aceptado;
	}
	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}
    
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public UsuarioDTO(Dueno dueno) {
    	username = dueno.getUsername();
    	nombre = dueno.getNombre();
    	apellido = dueno.getApellido();
    	telefono = dueno.getTelefono();
    	email = dueno.getEmail();
    	tipo = "dueno";
    	password = dueno.getPassword();
    }
    public UsuarioDTO(Administrador admin) {
    	username = admin.getUsername();
    	nombre = admin.getNombre();
    	apellido = admin.getApellido();
    	telefono = admin.getTelefono();
    	email = admin.getEmail();
    	tipo = "administrador";
    	password = admin.getPassword();
    }
    public UsuarioDTO(Veterinario vet) {
    	username = vet.getUsername();
    	nombre = vet.getNombre();
    	apellido = vet.getApellido();
    	telefono = vet.getTelefono();
    	email = vet.getEmail();
    	nombreConsultorio = vet.getNombreConsultorio();
    	domicilioConsultorio = vet.getDomicilioConsultorio();
    	aceptado = vet.isAceptado();
    	tipo = "veterinario";
    	password = vet.getPassword();
    }
    
    public UsuarioDTO() {}
	
	
}
