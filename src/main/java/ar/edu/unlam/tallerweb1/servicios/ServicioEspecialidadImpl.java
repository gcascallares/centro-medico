package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.EspecialidadDao;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;

@Service("servicioEspecialidad")
@Transactional
public class ServicioEspecialidadImpl implements ServicioEspecialidad {

	@Inject
	private EspecialidadDao servicioEspecialidadDao;
	
	
	public List <Especialidad> consultarEspecialidades() {
		return servicioEspecialidadDao.consultarEspecialidades();
	}
	
}