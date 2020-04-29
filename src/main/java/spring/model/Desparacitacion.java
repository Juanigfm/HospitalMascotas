package spring.model;

import java.sql.Date;
import javax.persistence.Column;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;

@Entity
public class Desparacitacion extends Evento
{
    @Column(name = "DROGA")
    private String droga;
    @Column(name = "RESULTADO")
    private String resultado;
    
    public Desparacitacion(final Date fecha, final String droga, final String resultado) {
        super(fecha);
        this.setDroga(droga);
        this.setResultado(resultado);
    }
    
    public String getDroga() {
        return this.droga;
    }
    
    public void setDroga(final String droga) {
        this.droga = droga;
    }
    
    public String getResultado() {
        return this.resultado;
    }
    
    public void setResultado(final String resultado) {
        this.resultado = resultado;
    }
    
    public Desparacitacion() {
    }
    
    public String toString() {
        return "Desparacitacion [droga=" + this.droga + ", resultado=" + this.resultado + ", getFecha()=" + this.getFecha() + ", getId()=" + this.getId() + "]";
    }
}