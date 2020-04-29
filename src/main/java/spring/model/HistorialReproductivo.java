package spring.model;

import java.sql.Date;
import javax.persistence.Column;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;

@Entity
public class HistorialReproductivo extends Evento
{
    @Column(name = "NRO_CACHORROS")
    private Integer nroCachorros;
    
    public HistorialReproductivo() {
    }
    
    public HistorialReproductivo(final Date fecha, final Integer nroCachorros) {
        super(fecha);
        this.nroCachorros = nroCachorros;
    }
    
    public Integer getNroCachorros() {
        return this.nroCachorros;
    }
    
    public void setNroCachorros(final Integer nroCachorros) {
        this.nroCachorros = nroCachorros;
    }
    
    @Override
    public String toString() {
        return "HistorialReproductivo [nroCachorros=" + this.nroCachorros + ", getFecha()=" + this.getFecha() + ", getId()=" + this.getId() + "]";
    }
}
