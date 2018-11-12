package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;


public interface ServicioTurnos {
	
	List<Medico> consultarMedico();
	
	List <Medico> listaDeMedicosPorEspecialidad (Long especialidadId);

	List<String> turnosDeMedicoEspecifico(Medico medico);

	List<String> listaDeDiasDisponibles(Long especialidadId);
	
	Medico buscarMedicoEspecifico(Long id);

	List<Turno> listaTurnosPorMedico(Medico medico);

	List<String> turnosDisponibles(List<String> listaTurnos, Long especialidadId, Long medicoId, String fecha);

	void guardarTurno(Turno turno);
}


