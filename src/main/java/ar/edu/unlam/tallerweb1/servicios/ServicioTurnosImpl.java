package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MedicoDao;
import ar.edu.unlam.tallerweb1.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;

@Service("servicioTurnos")
@Transactional
public class ServicioTurnosImpl implements ServicioTurnos {

	@Inject
	private MedicoDao servicioMedicoDao;
	
	@Inject
	private TurnoDao servicioTurnoDao;
	
	@Override
	public List <String> turnosDeMedicoEspecifico(Medico medico) {
		
		//guarda en medico el con lasespecificaciones elegidas pero desde la BD
		
		Integer horaDesde = medico.getHoraDesde();
		Integer horaHasta = medico.getHoraHasta();
		Integer minutoDesde = medico.getMinutoDesde();
		Integer minutoHasta = medico.getMinutoHasta();
		Integer intervalo = medico.getEspecialidad().getIntervalo();
		
		List <String> listaHorarios = new ArrayList<String>();
		while(horaDesde<horaHasta || (horaDesde==horaHasta && minutoDesde<=minutoHasta)) {
			listaHorarios.add(horaDesde+":"+(minutoDesde<10?minutoDesde+"0":minutoDesde));
			minutoDesde+=intervalo;
			if(minutoDesde>59)
				horaDesde++;
			minutoDesde%=60;
			
		}
		return listaHorarios;
	}

	public List<Medico> consultarMedico(){
		return servicioMedicoDao.consultarMedico();
	}
	
	public List<Medico> listaDeMedicosPorEspecialidad(Long especialidadId){
		return servicioMedicoDao.listaDeMedicosPorEspecialidad(especialidadId);
	}
	

	@Override
	public List<String> listaDeDiasDisponibles(Long especialidadId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico buscarMedicoEspecifico(Long id) {
		return servicioMedicoDao.MedicoEspecifico(id);
	}

	@Override
	public void guardarTurno(Long especialidadId, Long medicoId, String horario) {
		servicioTurnoDao.guardarTurno(especialidadId, medicoId, horario);
	}

	@Override
	public List<Turno> listaTurnos() {
		return servicioTurnoDao.listaTurnos();
	}

	
	
}