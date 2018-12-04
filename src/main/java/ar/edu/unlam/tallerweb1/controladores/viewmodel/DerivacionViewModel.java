package ar.edu.unlam.tallerweb1.controladores.viewmodel;

public class DerivacionViewModel {
	
	private Long turnoId;
	private Long medicoId;
	private Long especialidadId;
	private String horario;
	private String fecha;

	public Long getMedicoId() {
		return medicoId;
	}
	
	public void setMedicoId(Long medicoId) {
		this.medicoId = medicoId;
	}
	
	public Long getEspecialidadId() {
		return especialidadId;
	}
	
	public void setEspecialidadId(Long especialidadId) {
		this.especialidadId = especialidadId;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Long getTurnoId() {
		return turnoId;
	}

	public void setTurnoId(Long turnoId) {
		this.turnoId = turnoId;
	}
	
}
