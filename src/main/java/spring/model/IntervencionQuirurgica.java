package spring.model;

import java.sql.Date;
import javax.persistence.Column;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;

@Entity
public class IntervencionQuirurgica extends Evento {
    @Column(name = "descripcion")
    private String descripcion;
    
    public IntervencionQuirurgica(final Date fecha, final String descripcion) {
        super(fecha);
        this.setDescripcion(descripcion);
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    
    public IntervencionQuirurgica() {
    }
    
    @Override
    public String toString() {
        return "IntervencionQuirurgica [descripcion=" + this.descripcion + ", getFecha()=" + this.getFecha() + ", getId()=" + this.getId() + "]";
    }
}