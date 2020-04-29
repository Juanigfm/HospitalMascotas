package spring.model;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashMap;
import javax.persistence.ElementCollection;
import java.util.Map;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "ficha_publica")
public class FichaPublica
{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MASCOTA")
    private Mascota mascota;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DUENO")
    private Dueno dueno;
    
    @ElementCollection
    @Column(name = "DATOS_PUBLICOS")
    private Map<String, Boolean> datosPublicos;
    
    public FichaPublica(final Mascota mascota, final Dueno dueno) {
        this.mascota = mascota;
        this.dueno = dueno;
        this.datosPublicos = new HashMap<String, Boolean>();
        this.inicializarDatosPublicos();
    }
    
    private void inicializarDatosPublicos() {
        this.datosPublicos.put("NombreDueno", false);
        this.datosPublicos.put("ApellidoDueno", false);
        this.datosPublicos.put("EmailDueno", false);
        this.datosPublicos.put("TelefonoDueno", false);
        this.datosPublicos.put("NombreMascota", false);
        this.datosPublicos.put("NacimientoMascota", false);
        this.datosPublicos.put("RazaMascota", false);
        this.datosPublicos.put("EspecieMascota", false);
        this.datosPublicos.put("SexoMascota", false);
        this.datosPublicos.put("ColorMascota", false);
        this.datosPublicos.put("SenasMascota", false);
        this.datosPublicos.put("VeterinarioMascota", false);
        this.datosPublicos.put("FotoMascota", false);
    }
    
    public int getId() {
        return this.id;
    }
    
    public Mascota getMascota() {
        return this.mascota;
    }
    
    public void setMascota(final Mascota mascota) {
        this.mascota = mascota;
    }
    
    public Dueno getDueno() {
        return this.dueno;
    }
    
    public void setDueno(final Dueno dueno) {
        this.dueno = dueno;
    }
    
    public void setDatosPublicos(final HashMap<String, Boolean> datosPublicos) {
        this.datosPublicos = datosPublicos;
    }
    
    public String getNombreDueno() {
        return this.datosPublicos.get("NombreDueno") ? this.dueno.getNombre() : null;
    }
    
    public String getApellidoDueno() {
        return this.datosPublicos.get("ApellidoDueno") ? this.dueno.getApellido() : null;
    }
    
    public String getEmailDueno() {
        return this.datosPublicos.get("EmailDueno") ? this.dueno.getEmail() : null;
    }
    
    public String getTelefonoDueno() {
        return this.datosPublicos.get("TelefonoDueno") ? this.dueno.getTelefono() : null;
    }
    
    public String getNombreMascota() {
        return this.datosPublicos.get("NombreMascota") ? this.mascota.getNombre() : null;
    }
    
    public Date getNacimientoMascota() {
        return this.datosPublicos.get("NacimientoMascota") ? this.mascota.getFechaNacimiento() : null;
    }
    
    public String getRazaMascota() {
        return this.datosPublicos.get("RazaMascota") ? this.mascota.getRaza() : null;
    }
    
    public String getEspecieMascota() {
        return this.datosPublicos.get("EspecieMascota") ? this.mascota.getEspecie() : null;
    }
    
    public char getSexoMascota() {
        return this.datosPublicos.get("SexoMascota") ? Character.valueOf(this.mascota.getSexo()) : null;
    }
    
    public String getColorMascota() {
        return this.datosPublicos.get("ColorMascota") ? this.mascota.getColor() : null;
    }
    
    public String getSenasMascota() {
        return this.datosPublicos.get("SenasMascota") ? this.mascota.getSenasParticulares() : null;
    }
    
    public Veterinario getVeterinarioMascota() {
        return this.datosPublicos.get("VeterinarioMascota") ? this.mascota.getVeterinario() : null;
    }
    
    public String getFotoMascota() {
        return this.datosPublicos.get("FotoMascota") ? this.mascota.getFotoMascota() : null;
    }
    
    public void setVisibleNombreDueno(final Boolean valor) {
        this.datosPublicos.put("NombreDueno", valor);
    }
    
    public void setVisibleApellidoDueno(final Boolean valor) {
        this.datosPublicos.put("ApellidoDueno", valor);
    }
    
    public void setVisibleEmailDueno(final Boolean valor) {
        this.datosPublicos.put("EmailDueno", valor);
    }
    
    public void setVisibleTelefonoDueno(final Boolean valor) {
        this.datosPublicos.put("TelefonoDueno", valor);
    }
    
    public void setVisibleNombreMascota(final Boolean valor) {
        this.datosPublicos.put("NombreMascota", valor);
    }
    
    public void setVisibleVisibleNacimientoMascota(final Boolean valor) {
        this.datosPublicos.put("NacimientoMascota", valor);
    }
    
    public void setVisibleRazaMascota(final Boolean valor) {
        this.datosPublicos.put("RazaMascota", valor);
    }
    
    public void setVisibleEspecieMascota(final Boolean valor) {
        this.datosPublicos.put("EspecieMascota", valor);
    }
    
    public void setVisibleSexoMascota(final Boolean valor) {
        this.datosPublicos.put("SexoMascota", valor);
    }
    
    public void setVisibleColorMascota(final Boolean valor) {
        this.datosPublicos.put("ColorMascota", valor);
    }
    
    public void setVisibleSenasMascota(final Boolean valor) {
        this.datosPublicos.put("SenasMascota", valor);
    }
    
    public void setVisibleVeterinarioMascota(final Boolean valor) {
        this.datosPublicos.put("VeterinarioMascota", valor);
    }
    
    public void setVisibleFotoMascota(final Boolean valor) {
        this.datosPublicos.put("FotoMascota", valor);
    }
    
    public FichaPublica() {
    }
    
    @Override
    public String toString() {
        return "FichaPublica [id=" + this.id + "]";
    }
}