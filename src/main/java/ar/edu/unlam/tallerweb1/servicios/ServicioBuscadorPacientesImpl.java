package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.dao.BuscadorPacientesDao;

@Service("ServicioBuscadorPacientes")
@Transactional

public class ServicioBuscadorPacientesImpl implements ServicioBuscadorPacientes {
	
	@Inject
	private BuscadorPacientesDao buscadorPacientesDao;
	
	@Override
	public List <Paciente> listaPacientes(String apellido) {
			return buscadorPacientesDao.listaPacientes(apellido);
	}
	
	@Override
	public List <Turno> listaTurnoPaciente(Long dni){
		return buscadorPacientesDao.listaTurnoPaciente(dni);
	}
	
	public boolean modificarEstadoTurno(Long id) {
		return buscadorPacientesDao.modificarEstadoTurno(id);
	}
}
