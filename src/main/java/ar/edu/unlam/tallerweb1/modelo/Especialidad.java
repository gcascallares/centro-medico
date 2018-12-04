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
<<<<<<< HEAD
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
=======
	
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
	
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
	public void setIntervalo(Integer intervalo) {
		this.intervalo = intervalo;
	}
	
}
