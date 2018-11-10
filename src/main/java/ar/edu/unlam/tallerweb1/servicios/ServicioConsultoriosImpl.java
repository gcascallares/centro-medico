package ar.edu.unlam.tallerweb1.servicios;


import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ConsultoriosDao;
import ar.edu.unlam.tallerweb1.modelo.Consultorios;

@Service("servicioConsultorio")
@Transactional

public class ServicioConsultoriosImpl implements ServicioConsultorio{

	@Inject
	private ConsultoriosDao servicioConsultoriosDao;
	
	
	@Override
	public List<Consultorios> listaConsultorios() {
			return servicioConsultoriosDao.listaConsultorios();
	}


	@Override
	public void guardarConsultorio(Long consultorioId) {
		
		servicioConsultoriosDao.guardarConsultorio(consultorioId);
		
	}

	
	
}