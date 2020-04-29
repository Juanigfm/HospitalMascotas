package spring.clasesDTO;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import spring.model.Dueno;
import spring.model.Evento;
import spring.model.Mascota;
import spring.model.Veterinario;

public class MascotaDTO {

    private int id;
    private String nombre;
    private Date fechaNacimiento;
    private String raza;
    private String especie;
    private char sexo;
    private String color;
    private String senasParticulares;
    private String veterinarioTexto;
    private String fotoMascota;
    private boolean aceptada;
    private int veterinarioId;
    private int duenoId;
    private String duenoUsername;
    private String veterinarioUsername;
    private String duenoNombre; 
    private String veterinarioNombre;
//  @Transient
//  private int idDuenioTemp;

    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getSenasParticulares() {
		return senasParticulares;
	}
	public void setSenasParticulares(String senasParticulares) {
		this.senasParticulares = senasParticulares;
	}
	public String getVeterinarioTexto() {
		return veterinarioTexto;
	}
	public void setVeterinarioTexto(String veterinarioTexto) {
		this.veterinarioTexto = veterinarioTexto;
	}
	public String getFotoMascota() {
		return fotoMascota;
	}
	public void setFotoMascota(String fotoMascota) {
		this.fotoMascota = fotoMascota;
	}
	public boolean isAceptada() {
		return aceptada;
	}
	public void setAceptada(boolean aceptada) {
		this.aceptada = aceptada;
	}
	public int getVeterinarioId() {
		return veterinarioId;
	}
	public void setVeterinarioId(int veterinarioId) {
		this.veterinarioId = veterinarioId;
	}
	public int getDuenoId() {
		return duenoId;
	}
	public void setDuenoId(int duenoId) {
		this.duenoId = duenoId;
	}
	public String getDuenoUsername() {
		return this.duenoUsername;
	}
	public String getVeterinarioUsername() {
		return this.veterinarioUsername;
	}
	public String getDuenoNombre() {
		return this.duenoNombre;
	}
	public String getVeterinarioNombre() {
		return this.veterinarioNombre;
	}
	
	public MascotaDTO(Mascota m) {
		this.id = m.getId();
		this.nombre = m.getNombre();
		this.fechaNacimiento = m.getFechaNacimiento();
		this.raza = m.getRaza();
		this.especie = m.getEspecie();
		this.sexo = m.getSexo();
		this.color = m.getColor();
		this.senasParticulares = m.getSenasParticulares();
		this.veterinarioTexto = m.getVeterinarioTexto();
		this.fotoMascota = m.getFotoMascota();
		this.aceptada = m.isAceptada();
		this.duenoId = m.getDueno().getId();
		this.duenoNombre = m.getDueno().getNombre() + " " + m.getDueno().getApellido();
		if (m.getVeterinario() != null) {
			this.veterinarioId = m.getVeterinario().getId();
			this.veterinarioNombre = m.getVeterinario().getNombre() + " " + m.getVeterinario().getApellido();
		}
			
		
	}
	
	public MascotaDTO() {
		
	}
	

   
}
