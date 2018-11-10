package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Medico;


public interface ServicioTurnos {
	
	List<Medico> consultarMedico();
	
	List <Medico> listaDeMedicosPorEspecialidad (Long especialidadId);

	List<String> turnosDeMedicoEspecifico(Medico medico);

	List<String> listaDeDiasDisponibles(Long especialidadId);
	
	Medico buscarMedicoEspecifico(Long id);
	
	void guardarTurno(Long especialidadId, Long medicoId, String horario);
}


