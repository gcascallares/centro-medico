package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.dao.PacienteDao;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioPaciente")
@Transactional
public class ServicioPacienteImpl implements ServicioPaciente {
	
	@Inject
    private PacienteDao pacienteDao;
	
	@Override
	public Long obtenerPacienteId(Long id) {
		return pacienteDao.obtenerIdPaciente(id);
	}

	@Override
	public Paciente obtenerPaciente(Long idPaciente) {
		return pacienteDao.obtenerPaciente(idPaciente);
	}

	@Override
	public Usuario guardarContrasena(Long id, String contrasena) {
		return pacienteDao.guardarContrasena(id,contrasena);
	}

}
