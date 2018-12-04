package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Estudio;

<<<<<<< HEAD

=======
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
public interface EspecialidadDao {
	
	List <Especialidad> consultarEspecialidades();

	List<Estudio> listaDeEstudios(Especialidad especialidad);
	
}
