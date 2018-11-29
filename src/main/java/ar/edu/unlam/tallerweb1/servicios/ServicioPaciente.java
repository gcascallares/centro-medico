package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface ServicioPaciente {

	Long obtenerPacienteId(Long id);
	
	Paciente obtenerPaciente(Long idPaciente);
}
