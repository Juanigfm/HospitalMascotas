package spring.model;

import java.sql.Date;
import javax.persistence.Column;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;

@Entity
public class Enfermedad extends Evento
{
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    public Enfermedad(final Date fecha, final String descripcion) {
        super(fecha);
        this.setDescripcion(descripcion);
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Enfermedad() {
    }
    
    public String toString() {
        return "Enfermedad [descripcion=" + this.descripcion + ", getFecha()=" + this.getFecha() + ", getId()=" + this.getId() + "]";
    }
}