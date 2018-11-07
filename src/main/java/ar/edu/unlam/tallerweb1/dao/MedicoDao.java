package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Medico;

public interface MedicoDao {
	
	List <Medico> consultarMedico();

	List<Medico> listaDeMedicosPorEspecialidad(Integer especialidadId);

	Medico MedicoEspecifico(Medico medico);

}
