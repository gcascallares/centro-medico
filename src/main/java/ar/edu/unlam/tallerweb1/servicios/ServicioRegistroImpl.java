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
	public Paciente guardarPaciente (Paciente paciente) {
		
		return pacienteDao.guardarPaciente(paciente);
	}
	
	@Override
	public Usuario guardarUsuario (Usuario usuario) {
		
		return usuarioDao.guardarUsuario(usuario);
	}
	

}
