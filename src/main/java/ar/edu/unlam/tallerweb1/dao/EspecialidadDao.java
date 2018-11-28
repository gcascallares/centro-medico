package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Estudio;


public interface EspecialidadDao {
	
	List <Especialidad> consultarEspecialidades();

	List<Estudio> listaDeEstudios(Especialidad especialidad);
	
}
