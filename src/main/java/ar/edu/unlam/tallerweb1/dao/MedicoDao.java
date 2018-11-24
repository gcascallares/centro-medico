package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface MedicoDao {
	
	List <Medico> consultarMedico();

	List<Medico> listaDeMedicosPorEspecialidad(Long especialidadId);

	Medico MedicoEspecifico(Long id);

	List<DiasLaborales> buscarDiasLaborales(Long id);

	Medico buscarMedicoSegunUsuario(Usuario usuario);

	Especialidad especialidadDelMedico(Long medicoid);

}
