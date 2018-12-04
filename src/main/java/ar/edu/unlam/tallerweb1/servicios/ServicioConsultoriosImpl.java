package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.ConsultoriosDao;
import ar.edu.unlam.tallerweb1.modelo.Consultorio;

@Service("servicioConsultorio")
@Transactional
public class ServicioConsultoriosImpl implements ServicioConsultorio{

	@Inject
	private ConsultoriosDao servicioConsultoriosDao;
	
	@Override
	public List<Consultorio> listaConsultorios() {
			return servicioConsultoriosDao.listaConsultorios();
	}

	@Override
	public Consultorio buscarConsultorioEspecifico(Long consultorioId) {
		return servicioConsultoriosDao.buscarConsultorioEspecifico(consultorioId);
	}

	@Override
	public void guardarConsultorio(Consultorio consultorio){
		servicioConsultoriosDao.guardarConsultorio(consultorio);
	}
	
	@Override
	public Consultorio buscarConsultorioPorMedico (Long medicoId) {
		return servicioConsultoriosDao.buscarConsultorioPorMedico(medicoId);
	}

}