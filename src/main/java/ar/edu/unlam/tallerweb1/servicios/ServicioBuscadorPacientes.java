package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;

public interface ServicioBuscadorPacientes {
	
	List <Paciente> listaPacientes(Long dni);

	
	boolean modificarEstadoTurno(Long id);
	
	List <Turno> listaTurnos(Long id);
	
	
	
	
}
