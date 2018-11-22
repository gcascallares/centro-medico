package ar.edu.unlam.tallerweb1.controladores.viewmodel;

public class TurnoComentarioViewModel {
	private Long medicoId;
	private Long id;
	private Long consultorioId;
	private String descripcion;
	public Long getMedicoId() {
		return medicoId;
	}
	public void setMedicoId(Long medicoId) {
		this.medicoId = medicoId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getConsultorioId() {
		return consultorioId;
	}
	public void setConsultorioId(Long consultorioId) {
		this.consultorioId = consultorioId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
