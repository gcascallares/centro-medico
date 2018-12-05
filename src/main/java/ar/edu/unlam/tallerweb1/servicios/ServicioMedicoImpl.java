package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MedicoDao;
import ar.edu.unlam.tallerweb1.modelo.Consultorio;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
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
	
	@Override
	public Especialidad especialidadDelMedico (Long medicoid) {
		return medicoDao.especialidadDelMedico(medicoid);
	}

	@Override
	public List<Medico> getMedicos() {
		return medicoDao.getMedicos();
	}
	
	@Override
	public List<Medico> listaMedicos(){
		return medicoDao.listaMedicos();
	}

	@Override
	public Consultorio tieneConsultorio(Long medicoId) {
		return medicoDao.tieneConsultorio(medicoId);
	}

	@Override
	public void sacarConsultorio(Long id) {
		medicoDao.sacarConsultorio(id);
		
	}

}
