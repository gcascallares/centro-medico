package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MedicoDao;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioMedico")
@Transactional
public class ServicioMedicoImpl implements ServicioMedico {

	@Inject
	private MedicoDao medicoDao;
	
	@Override
	public List<DiasLaborales> buscarDiasLaborales(Long id) {
		return medicoDao.buscarDiasLaborales(id);
	}

	@Override
	public Medico traerMedicoSegunUsuario(Usuario usuario) {
		return medicoDao.buscarMedicoSegunUsuario(usuario);
	}

}
