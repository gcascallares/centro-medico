package ar.edu.unlam.tallerweb1.controladores.viewmodel;

public class TurnoViewModel {
private Long medicoId;
private Long especialidadId;
private String horario;
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

}
