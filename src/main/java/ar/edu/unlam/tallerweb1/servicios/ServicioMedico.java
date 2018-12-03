package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioMedico {
	
	
	List <DiasLaborales> buscarDiasLaborales(Long id);
	
	Medico  traerMedicoSegunUsuario(Usuario usuario);
	
	Especialidad especialidadDelMedico(Long medicoid);

	List<Medico> getMedicos();

	List<Medico> listaMedicos();
}
