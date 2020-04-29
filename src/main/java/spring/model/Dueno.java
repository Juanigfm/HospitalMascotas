package spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

//import spring.clasesDTO.DuenoDTO;
import spring.clasesDTO.UsuarioDTO;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
public class Dueno extends Usuario {
	
    @JsonIgnore
    @OneToMany(mappedBy = "dueno", fetch = FetchType.LAZY)
    private List<Mascota> mascotas;
    
    @JsonIgnore
    @OneToMany(mappedBy = "dueno", fetch = FetchType.LAZY)
    private List<Recordatorio> recordatorios;
    
    public Dueno(final String nombre, final String apellido, final String telefono, final String email) {
        super(nombre, apellido, telefono, email);
    }
    
    public void eliminarMascota(final Mascota mascota) {
        this.mascotas.remove(mascota);
    }
    
    public void agregarMascota(final Mascota mascota) {
        this.mascotas.add(mascota);
    }
    
    public void eliminarRecordatorio(final Recordatorio recordatorio) {
        this.recordatorios.remove(recordatorio);
        recordatorio.setDueno((Dueno)null);
    }
    
    public void agregarRecordatorio(final Recordatorio recordatorio) {
        this.recordatorios.add(recordatorio);
        recordatorio.setDueno(this);
    }
    
    public Dueno() {
    }
    
    public String toString() {
        return "Dueno [getNombre()=" + this.getNombre() + ", getApellido()=" + this.getApellido() + ", getTelefono()=" + this.getTelefono() + ", getEmail()=" + this.getEmail() + ", getId()=" + this.getId() + "]";
    }
    
    public List<Mascota> getMascotas() {
        return this.mascotas;
    }
    
    public List<Recordatorio> getRecordatorios() {
        return this.recordatorios;
    }
    
    public void setMascotas(final List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
    
    public void setRecordatorios(final List<Recordatorio> recordatorios) {
        this.recordatorios = recordatorios;
    }
    
    public Dueno(final int id) {
        this.setId(id);
    }
    
    public Dueno(UsuarioDTO dueno) {
    	setUsername(dueno.getUsername());
    	setNombre(dueno.getNombre());
    	setApellido(dueno.getApellido());
    	setTelefono(dueno.getTelefono());
    	setEmail(dueno.getEmail());
    	setPassword(dueno.getPassword());
    }

	public void actualizar(Dueno dueno) {
    	setNombre(dueno.getNombre());
    	setApellido(dueno.getApellido());
    	setTelefono(dueno.getTelefono());
    	setEmail(dueno.getEmail());
    	setPassword(dueno.getPassword());
	}
}
