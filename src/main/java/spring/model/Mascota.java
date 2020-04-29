package spring.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import spring.clasesDTO.MascotaDTO;

@Entity
@Table(name = "mascota")
public class Mascota {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_MASCOTA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "FECHA_NACIMIENTO")
    private Date fechaNacimiento;
    
    @Column(name = "RAZA")
    private String raza;
    
    @Column(name = "ESPECIE")
    private String especie;
    
    @Column(name = "SEXO")
    private char sexo;
    
    @Column(name = "COLOR")
    private String color;
    
    @Column(name = "SENAS_PARTICULARES")
    private String senasParticulares;
    
    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_VETERINARIO")
    private Veterinario veterinario;
    
    @Column(name = "VETERINARIO_TEXTO")
    private String veterinarioTexto;
    
    @Column(name = "FOTO_MASCOTA")
    private String fotoMascota;
    
    @JsonIgnore
    @OneToMany(mappedBy = "mascota", fetch = FetchType.LAZY)
    private List<Evento> eventos;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_DUENO")
    private Dueno dueno;
    
    @Column(name = "aceptada")
    private boolean aceptada;
    
    @Transient
    private int idDuenioTemp;
    
    public boolean isAceptada() {
        return this.aceptada;
    }
    
    public void setAceptada(final boolean aceptada) {
        this.aceptada = aceptada;
    }
    
    public int getId() {
        return this.id;
    }
    
    public Veterinario getVeterinario() {
        return this.veterinario;
    }
    
    public void setVeterinario(final Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    
    public List<Evento> getEventos() {
        return this.eventos;
    }
    
    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public void setSenasParticulares(String senasParticulares) {
        this.senasParticulares = senasParticulares;
    }
    
    public void setVeterinarioTexto(String veterinarioTexto) {
        this.veterinarioTexto = veterinarioTexto;
    }
    
    public void setFotoMascota(String fotoMascota) {
        this.fotoMascota = fotoMascota;
    }
    
    public void cargarEvento(Evento evento) {
        this.eventos.add(evento);
    }
    
    public void eliminarEvento(final Evento evento) {
        this.eventos.remove(evento);
    }
    
    public String getNombre() {
        return this.nombre;
    }
    
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public String getRaza() {
        return this.raza;
    }
    
    public String getEspecie() {
        return this.especie;
    }
    
    public char getSexo() {
        return this.sexo;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public String getSenasParticulares() {
        return this.senasParticulares;
    }
    
    public String getVeterinarioTexto() {
        return this.veterinarioTexto;
    }
    
    public String getFotoMascota() {
        return this.fotoMascota;
    }
    
    public Mascota() {
    }
    
    public Mascota(final String nombre, final Date fechaNacimiento, final String raza, final String especie, final char sexo, final String color, final String senasParticulares, final String veterinarioTexto, final Veterinario veterinario, final String fotoMascota, final boolean aceptada, final Dueno dueno) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.especie = especie;
        this.sexo = sexo;
        this.color = color;
        this.senasParticulares = senasParticulares;
        this.veterinarioTexto = veterinarioTexto;
        this.veterinario = veterinario;
        this.fotoMascota = fotoMascota;
        this.aceptada = aceptada;
        this.dueno = dueno;
    }
    
    public Dueno getDueno() {
        return this.dueno;
    }
    
    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public void editarMascota(final String nombre, final Date fechaNacimiento, final String raza, final String especie, final char sexo, final String color, final String senasParticulares, final String veterinarioTexto, final Veterinario veterinario, final String fotoMascota) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.especie = especie;
        this.sexo = sexo;
        this.color = color;
        this.senasParticulares = senasParticulares;
        this.veterinarioTexto = veterinarioTexto;
        this.veterinario = veterinario;
        this.fotoMascota = fotoMascota;
    }
    
    @Override
    public String toString() {
        return "Mascota [id=" + this.id + ", nombre=" + this.nombre + ", fechaNacimiento=" + this.fechaNacimiento + ", raza=" + this.raza + ", especie=" + this.especie + ", sexo=" + this.sexo + ", color=" + this.color + ", senasParticulares=" + this.senasParticulares + ", veterinarioTexto=" + this.veterinarioTexto + ", aceptada=" + this.aceptada + "]";
    }
    
    public String getNombreVeterinario() {
        if (this.veterinario != null) {
            return this.veterinario.getNombre();
        }
        return null;
    }
    
    public void setDuenoId(final int id) {
       this.idDuenioTemp = id;
    }
    
    public void setVetId(final int id) {
        this.veterinario = new Veterinario(id);
    }

	public int getIdDuenioTemp() {
		return idDuenioTemp;
	}

	public void setIdDuenioTemp(int idDuenioTemp) {
		this.idDuenioTemp = idDuenioTemp;
	}
	
	public Mascota(MascotaDTO m) {
		this.id = m.getId();
		this.nombre = m.getNombre();
		this.fechaNacimiento = m.getFechaNacimiento();
		this.raza = m.getRaza();
		this.especie = m.getEspecie();
		this.sexo = m.getSexo();
		this.color = m.getColor();
		this.senasParticulares = m.getSenasParticulares();
//		this.veterinario = m.getVeterinario();
		this.veterinarioTexto = m.getVeterinarioTexto();
		this.fotoMascota = m.getFotoMascota();
		this.aceptada = m.isAceptada();
	}
    
    
}