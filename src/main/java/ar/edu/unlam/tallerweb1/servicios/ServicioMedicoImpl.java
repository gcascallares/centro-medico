package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.EspecialidadDao;
import ar.edu.unlam.tallerweb1.dao.MedicoDao;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;

@Service("servicioMedico")
@Transactional
public class ServicioMedicoImpl implements ServicioMedico {

	@Inject
	private MedicoDao medicoDao;
	
	@Override
	public List<DiasLaborales> buscarDiasLaborales(Long id) {
		return medicoDao.buscarDiasLaborales(id);
	}

}
