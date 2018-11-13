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
	
	private String dia1;
	private String dia2;
	private String dia3;
	private String dia4;
	private String dia5;
	
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

	public String getDia1() {
		return dia1;
	}

	public void setDia1(String dia1) {
		this.dia1 = dia1;
	}

	public String getDia2() {
		return dia2;
	}

	public void setDia2(String dia2) {
		this.dia2 = dia2;
	}

	public String getDia3() {
		return dia3;
	}

	public void setDia3(String dia3) {
		this.dia3 = dia3;
	}

	public String getDia4() {
		return dia4;
	}

	public void setDia4(String dia4) {
		this.dia4 = dia4;
	}

	public String getDia5() {
		return dia5;
	}

	public void setDia5(String dia5) {
		this.dia5 = dia5;
	}

	public List<Medico> getMedicos() {
		return Medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		Medicos = medicos;
	}
	
	
}
