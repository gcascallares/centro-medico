package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Consultorios;

public interface ServicioConsultorio {

	List <Consultorios> listaConsultorios();
	
	void guardarConsultorio(Long consultorioId);
	
}
