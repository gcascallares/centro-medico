package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Consultorios;


@Service("servicioConsultorio")
@Transactional

public class ServicioConsultoriosImpl implements ServicioConsultorio{

	@Override
	public List<Consultorios> listaConsultorios() {
	
		return null;
	}

	
	
}