package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Consultorio;

public interface ServicioConsultorio {

	List <Consultorio> listaConsultorios();
	
	void guardarConsultorio(Long consultorioId);
	
}
