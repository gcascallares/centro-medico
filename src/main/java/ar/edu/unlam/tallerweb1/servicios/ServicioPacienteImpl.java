package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.PacienteDao;

@Service("servicioPaciente")
@Transactional
public class ServicioPacienteImpl implements ServicioPaciente {
	@Inject
    private PacienteDao pacienteDao;
	
	@Override
	public Long obtenerPacienteId(Long id) {
		return pacienteDao.obtenerIdPaciente(id);
	}

}
