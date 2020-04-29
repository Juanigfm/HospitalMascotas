package spring.model;

import java.sql.Date;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Column;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;

@Entity
public class Visita extends Evento
{
    @Column(name = "PESO")
    private Float peso;
    @ManyToOne(fetch = FetchType.LAZY)
    private Veterinario profesional;
    @Column(name = "MOTIVO")
    private String motivo;
    @Column(name = "DIAGNOSTICO")
    private String diagnostico;
    @Column(name = "INDICACIONES")
    private String indicaciones;
    
    public Visita(final Date fecha, final Float peso, final Veterinario profesional, final String motivo, final String diagnostico, final String indicaciones) {
        super(fecha);
        this.setProfesional(profesional);
        this.setMotivo(motivo);
        this.setDiagnostico(diagnostico);
        this.setIndicaciones(indicaciones);
    }
    
    public Float getPeso() {
        return this.peso;
    }
    
    public void setPeso(final Float peso) {
        this.peso = peso;
    }
    
    public Veterinario getProfesional() {
        return this.profesional;
    }
    
    public void setProfesional(final Veterinario profesional) {
        this.profesional = profesional;
    }
    
    public String getMotivo() {
        return this.motivo;
    }
    
    public void setMotivo(final String motivo) {
        this.motivo = motivo;
    }
    
    public String getDiagnostico() {
        return this.diagnostico;
    }
    
    public void setDiagnostico(final String diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    public String getIndicaciones() {
        return this.indicaciones;
    }
    
    public void setIndicaciones(final String indicaciones) {
        this.indicaciones = indicaciones;
    }
    
    public Visita() {
    }
    
    @Override
    public String toString() {
        return "Visita [peso=" + this.peso + ", motivo=" + this.motivo + ", diagnostico=" + this.diagnostico + ", indicaciones=" + this.indicaciones + ", getFecha()=" + this.getFecha() + ", getId()=" + this.getId() + "]";
    }
}