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
import javax.persistence.InheritanceType;
import javax.persistence.Inheritance;
import javax.persistence.Entity;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "evento")
public class Evento
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_EVENTO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "FECHA")
    private Date fecha;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MASCOTA")
    private Mascota mascota;
    
    public Evento(final Date fecha) {
        this.fecha = fecha;
    }
    
    public Date getFecha() {
        return this.fecha;
    }
    
    public Mascota getMascota() {
        return this.mascota;
    }
    
    public void setMascota(final Mascota mascota) {
        this.mascota = mascota;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setFecha(final Date fecha) {
        this.fecha = fecha;
    }
    
    Evento() {
    }
}