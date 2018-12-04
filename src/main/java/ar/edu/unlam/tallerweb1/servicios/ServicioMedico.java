package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

<<<<<<< HEAD
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioMedico {
	
	
	List <DiasLaborales> buscarDiasLaborales(Long id);
	
	Medico  traerMedicoSegunUsuario(Usuario usuario);
	
	Especialidad especialidadDelMedico(Long medicoid);

	List<Medico> getMedicos();
=======
import ar.edu.unlam.tallerweb1.modelo.Consultorio;
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

	Consultorio tieneConsultorio(Long medicoId);
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
}
