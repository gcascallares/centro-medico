package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Medico;


public interface ServicioTurnos {
	
	List<Medico> consultarMedico();
	
	List <Medico> listaDeMedicosPorEspecialidad (Integer especialidadId);

	List<String> turnosDeMedicoEspecifico(Medico medico);

}
