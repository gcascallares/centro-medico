package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Especialidad {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombreEspecialidad;
	
	private Integer intervalo;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}
	
	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}
	
	public Integer getIntervalo() {
		return intervalo;
	}
	
	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}
	
}
