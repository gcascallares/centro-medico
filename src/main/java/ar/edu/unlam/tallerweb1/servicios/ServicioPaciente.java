package ar.edu.unlam.tallerweb1.servicios;

<<<<<<< HEAD
public interface ServicioPaciente {

	Long obtenerPacienteId(Long id);
=======
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioPaciente {

	Long obtenerPacienteId(Long id);
	
	Paciente obtenerPaciente(Long idPaciente);

	Usuario guardarContrasena(Long id, String contrasena);
	
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
}
