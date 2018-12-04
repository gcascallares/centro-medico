package ar.edu.unlam.tallerweb1.servicios;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.PacienteDao;
import ar.edu.unlam.tallerweb1.dao.UsuarioDao;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Service("servicioRegistro")
@Transactional
public class ServicioRegistroImpl implements ServicioRegistro {
	
	@Inject
	private PacienteDao pacienteDao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Override
	public void guardarPaciente (Paciente paciente) {
<<<<<<< HEAD
		
		pacienteDao.guardarPaciente(paciente);
	}
	
	@Override
	public void guardarUsuario (Usuario usuario) {
		
		usuarioDao.guardarUsuario(usuario);
=======
		pacienteDao.guardarPaciente(paciente);
	}
	
	@Override
	public Usuario guardarUsuario (Paciente paciente) {
		return usuarioDao.guardarUsuario(paciente);
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
	}
	

}
