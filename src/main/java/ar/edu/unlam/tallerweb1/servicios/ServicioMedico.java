package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;

public interface ServicioMedico {
	
	List <DiasLaborales> buscarDiasLaborales(Long id);

}
