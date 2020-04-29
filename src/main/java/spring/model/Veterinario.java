package spring.model;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

import spring.clasesDTO.UsuarioDTO;

import java.util.List;
import javax.persistence.DiscriminatorValue;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Veterinario extends Usuario {
	
    @JsonIgnore
    @OneToMany(mappedBy = "veterinario", fetch = FetchType.LAZY)
    private List<Recordatorio> recordatorios;
    
    @Column(name = "NOMBRE_CONSULTORIO")
    private String nombreConsultorio;
    
    @Column(name = "DOMICILIO_CONSULTORIO")
    private String domicilioConsultorio;
    
    @Column(name = "ACEPTADO")
    private boolean aceptado;
    
    public boolean isAceptado() {
        return this.aceptado;
    }
    
    public List<Recordatorio> getRecordatorios() {
        return this.recordatorios;
    }
    
    public void setRecordatorios(final List<Recordatorio> recordatorios) {
        this.recordatorios = recordatorios;
    }
    
    public void setAceptado(final boolean activo) {
        this.aceptado = this.aceptado;
    }
    
    public Veterinario(final String nombre, final String apellido, final String telefono, final String email, final String nombreConsultorio, final String domicilioConsultorio, final boolean aceptado) {
        super(nombre, apellido, telefono, email);
        this.setNombreConsultorio(nombreConsultorio);
        this.setDomicilioConsultorio(domicilioConsultorio);
        this.aceptado = aceptado;
    }
    
    public Veterinario() {
    }
    
    public void eliminarRecordatorio(final Recordatorio recordatorio) {
        this.recordatorios.remove(recordatorio);
    }
    
    public void agregarRecordatorio(final Recordatorio recordatorio) {
        this.recordatorios.add(recordatorio);
    }
    
    public String getNombreConsultorio() {
        return this.nombreConsultorio;
    }
    
    public void setNombreConsultorio(final String nombreConsultorio) {
        this.nombreConsultorio = nombreConsultorio;
    }
    
    public String getDomicilioConsultorio() {
        return this.domicilioConsultorio;
    }
    
    public void setDomicilioConsultorio(final String domicilioConsultorio) {
        this.domicilioConsultorio = domicilioConsultorio;
    }
    
    @Override
    public String toString() {
        return "Veterinario [nombreConsultorio=" + this.nombreConsultorio + ", domicilioConsultorio=" + this.domicilioConsultorio + ", aceptado=" + this.aceptado + ", getNombre()=" + this.getNombre() + ", getApellido()=" + this.getApellido() + ", getTelefono()=" + this.getTelefono() + ", getEmail()=" + this.getEmail() + ", getId()=" + this.getId() + "]";
    }
    
    public Veterinario(final int id) {
        this.setId(id);
    }
    
    public Veterinario(UsuarioDTO vets) {
    	setUsername(vets.getUsername());
    	setNombre(vets.getNombre());
    	setApellido(vets.getApellido());
    	setTelefono(vets.getTelefono());
    	setEmail(vets.getEmail());
    	setPassword(vets.getPassword());
    	if(vets.getNombreConsultorio()!=null)
    		setNombreConsultorio(vets.getNombreConsultorio());
    	if(vets.getDomicilioConsultorio()!=null)
    		setDomicilioConsultorio(vets.getDomicilioConsultorio());
    }

	public void actualizar(Veterinario vets) {
    	setNombre(vets.getNombre());
    	setApellido(vets.getApellido());
    	setTelefono(vets.getTelefono());
    	setEmail(vets.getEmail());
    	setPassword(vets.getPassword());
		setNombreConsultorio(vets.getNombreConsultorio());
		setDomicilioConsultorio(vets.getDomicilioConsultorio());
	}
}