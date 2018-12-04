package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface PacienteDao {

	void guardarPaciente(Paciente paciente);

	Long obtenerIdPaciente(Long id);

	Paciente obtenerPaciente(Long idPaciente);

	Usuario guardarContrasena(Long id, String contrasena);

}
