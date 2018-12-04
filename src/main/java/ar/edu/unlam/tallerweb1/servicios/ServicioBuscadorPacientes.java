package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;

public interface ServicioBuscadorPacientes {
	
	List <Paciente> listaPacientes(Long dni);
<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
	
	boolean modificarEstadoTurno(Long id);
	
	boolean modificarEstadoTurnoRechazado(Long id);
	
	List <Turno> listaTurnos(Long id);
	
	
	
	
}
