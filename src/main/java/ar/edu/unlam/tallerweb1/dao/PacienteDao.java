package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
<<<<<<< HEAD

public interface PacienteDao {

	void guardarPaciente(Paciente paciente);

	Long obtenerIdPaciente(Long id);
=======
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface PacienteDao {

	void guardarPaciente(Paciente paciente);

	Long obtenerIdPaciente(Long id);

	Paciente obtenerPaciente(Long idPaciente);

	Usuario guardarContrasena(Long id, String contrasena);
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git

}
