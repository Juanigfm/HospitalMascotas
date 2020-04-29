package spring.model;

import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Date;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "recordatorio")
public class Recordatorio
{
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "FECHA")
    private Date fecha;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DUENO")
    private Dueno dueno;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MASCOTA")
    private Mascota mascota;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_VETERINARIO")
    private Veterinario veterinario;
    
    public Veterinario getVeterinario() {
        return this.veterinario;
    }
    
    public void setVeterinario(final Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    
    public Recordatorio() {
    }
    
    public Recordatorio(final Date fecha, final String descripcion, final Dueno dueno, final Mascota mascota) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.dueno = dueno;
        this.mascota = mascota;
    }
    
    public int getId() {
        return this.id;
    }
    
    public Dueno getDueno() {
        return this.dueno;
    }
    
    public void setDueno(final Dueno dueno) {
        this.dueno = dueno;
    }
    
    public Mascota getMascota() {
        return this.mascota;
    }
    
    public void setMascota(final Mascota mascota) {
        this.mascota = mascota;
    }
    
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }
    
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }
    
    @Override
    public String toString() {
        return "Recordatorio [id=" + this.id + ", fecha=" + this.fecha + ", descripcion=" + this.descripcion + ", veterinario=" + this.veterinario + "]";
    }
}