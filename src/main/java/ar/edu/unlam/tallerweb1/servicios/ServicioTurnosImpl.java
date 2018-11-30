package ar.edu.unlam.tallerweb1.servicios;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.dao.MedicoDao;
import ar.edu.unlam.tallerweb1.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.modelo.Atencion;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

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
	public List<DiasLaborales> listaDeDiasDisponibles(Long especialidadId) {
		return servicioTurnoDao.listaDeDiasDisponibles(especialidadId);
	}

	@Override
	public Medico buscarMedicoEspecifico(Long id) {
		return servicioMedicoDao.MedicoEspecifico(id);
	}

	@Override
	public Turno guardarTurno(Turno turno, Long idUsuario) {
		return servicioTurnoDao.guardarTurno(turno,idUsuario);
	}
	
	@Override
	public void guardarTurnoRecepcionista(Turno turno) {
		servicioTurnoDao.guardarTurnoRecepcionista(turno);
	}

	@Override
	public List<Turno> listaTurnosPorMedico(Medico medico, String diaActual) {
		return servicioTurnoDao.listaTurnosPorMedico(medico, diaActual);
	}

	@Override
	public List<String> turnosDisponibles(List<String> listaTurnos, Long especialidadId, Long medicoId, String fecha) {
		return servicioTurnoDao.turnosDisponibles(listaTurnos,especialidadId,medicoId,fecha);
	}

	public String diaActual(){

		Calendar fecha = new GregorianCalendar();
	    int ano = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH)+1;
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    String fechaActual = dia+"-"+mes+"-"+ano;
		return fechaActual;
		
	}
	
	public String diaSiguiente(){

		Calendar fecha = new GregorianCalendar();
	    int ano = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH)+1;
	    int dia = fecha.get(Calendar.DAY_OF_MONTH)+1;
	    String fechaActual = dia+"-"+mes+"-"+ano;
		return fechaActual;
		
	}
	
	@Override
	public List<Medico> listaDeMedicosDisponibles(Long especialidadId, Long diaId) {
		return servicioTurnoDao.listaDeMedicosDisponibles(especialidadId, diaId);
	}
	
	@Override
	public List<Atencion> mostrarHistoriaClinica(Long id){
		return servicioTurnoDao.mostrarHistoriaClinica(id);
	}
	
	@Override
	public Paciente mostrarDatosPaciente(Long id) {
		return servicioTurnoDao.mostrarDatosPaciente(id);
	}

	@Override
	public void cambiarEstadoAtendido(Long id) {
		servicioTurnoDao.cambiarEstadoAtendido(id);
		
	}

	@Override
	public void agregarDescripcion(Long turnoId,String descripcion,Long estudio) {
		servicioTurnoDao.agregarDescripcion(turnoId,descripcion,estudio);		
	}

	@Override
	public void agregarDerivacion(Long pacienteId, Long idMedico) {
		servicioTurnoDao.agregarDerivacion(pacienteId, idMedico);
		
	}
	
	@Override
	public List<Turno> listaDeDerivacion(Long usuarioId) {
		return servicioTurnoDao.listaDeDerivacion(usuarioId);
	}
	
	@Override
	public Turno guardarDerivacion (Long turnoId,String fecha, String horario ,Long especialidadId, Long medicoId) {
		return servicioTurnoDao.guardarDerivacion(turnoId,fecha,horario,especialidadId,medicoId);
	}
	
	@Override
	public void guardarAtencion(String mensaje, Long pacienteId, Long medicoId, String fecha) {
		servicioMedicoDao.guardarAtencion(mensaje, pacienteId, medicoId, fecha);
	}

	@Override
	public List<Turno> listaTodosLosTurnos(Medico medico) {
		return servicioTurnoDao.listaTodosLosTurnos(medico);
	}

	@Override
	public List<Turno> listaTurnosManana(Medico medico, String diaSiguiente) {
		return servicioTurnoDao.listaTurnosManana(medico, diaSiguiente);
	}
}