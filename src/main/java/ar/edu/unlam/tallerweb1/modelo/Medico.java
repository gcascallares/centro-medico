package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Especialidad especialidad;
	private Integer horaDesde;
	private Integer minutoDesde;
	private Integer horaHasta;
	private Integer minutoHasta;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public Integer getHoraDesde() {
		return horaDesde;
	}
	public void setHoraDesde(Integer horaDesde) {
		this.horaDesde = horaDesde;
	}
	public Integer getMinutoDesde() {
		return minutoDesde;
	}
	public void setMinutoDesde(Integer minutoDesde) {
		this.minutoDesde = minutoDesde;
	}
	public Integer getHoraHasta() {
		return horaHasta;
	}
	public void setHoraHasta(Integer horaHasta) {
		this.horaHasta = horaHasta;
	}
	public Integer getMinutoHasta() {
		return minutoHasta;
	}
	public void setMinutoHasta(Integer minutoHasta) {
		this.minutoHasta = minutoHasta;
	}
	
}
