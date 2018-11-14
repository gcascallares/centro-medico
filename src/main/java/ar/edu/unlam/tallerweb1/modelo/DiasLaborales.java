package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class DiasLaborales {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "dias_medicos",
			   joinColumns= {@JoinColumn(name="dia_id")},
			   inverseJoinColumns= {@JoinColumn(name="medico_id")})
	List <Medico> Medicos = new ArrayList<Medico>();

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

	public List<Medico> getMedicos() {
		return Medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		Medicos = medicos;
	}
	
	
}
