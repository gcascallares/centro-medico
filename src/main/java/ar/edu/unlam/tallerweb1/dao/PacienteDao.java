package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface PacienteDao {

	void guardarPaciente(Paciente paciente);

	Long obtenerIdPaciente(Long id);

	Paciente obtenerPaciente(Long idPaciente);

}
