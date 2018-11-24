package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;

public interface BuscadorPacientesDao {
	
	List <Paciente> listaPacientes(Long dni);
	
	boolean modificarEstadoTurno(Long id);
	
	List <Turno> listaTurnos(Long id);

	boolean modificarEstadoTurnoRechazado(Long id);
}
