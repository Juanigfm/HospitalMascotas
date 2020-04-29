package spring.model;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorColumn;
import org.springframework.stereotype.Component;
import javax.persistence.Table;
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.Entity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "usuario")
@DiscriminatorColumn(name = "DTYPE", discriminatorType = DiscriminatorType.STRING)
public class Usuario {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "USERNAME")
    private String username;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD")
    private String password;
    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "APELLIDO")
    private String apellido;
    
    @Column(name = "TELEFONO")
    private String telefono;
    
    @Column(name = "EMAIL")
    private String email;
    
    public String getNombre() {
        return this.nombre;
    }
    
    public String getApellido() {
        return this.apellido;
    }
    
    public String getTelefono() {
        return this.telefono;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(final String apellido) {
        this.apellido = apellido;
    }
    
    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public Usuario(final String nombre, final String apellido, final String telefono, final String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }
    
    public Usuario() {
    }
}