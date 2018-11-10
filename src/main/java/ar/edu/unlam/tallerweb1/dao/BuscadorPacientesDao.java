package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;

public interface BuscadorPacientesDao {
	
	List <Paciente> listaPacientes(String apellido);
	
	List <Turno> listaTurnoPaciente(Long dni);
	
	boolean modificarEstadoTurno(Long id);
}
