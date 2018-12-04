package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Estudio;

public interface ServicioEspecialidad {
	
	List <Especialidad> consultarEspecialidades();

	List<Estudio> listaDeEstudios(Especialidad especialidad);
<<<<<<< HEAD
=======
	
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
}
