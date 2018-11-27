package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.viewmodel.TurnoViewModel;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;

import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;

import ar.edu.unlam.tallerweb1.servicios.ServicioBuscadorPacientes;
import ar.edu.unlam.tallerweb1.servicios.ServicioEspecialidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioMedico;
import ar.edu.unlam.tallerweb1.servicios.ServicioPaciente;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;


@Controller
public class ControladorTurnos {

	@Inject
	private ServicioTurnos servicioTurnos;
	
	@Inject
	private ServicioEspecialidad servicioEspecialidad;
	
	@Inject
	private ServicioBuscadorPacientes servicioBuscadorPacientes;
	
	@Inject
	private ServicioMedico servicioMedico;
	
	@Inject
	private ServicioPaciente servicioPaciente;
	
	@Inject
    private SessionFactory sessionFactory;
	
//	Paso 1 = selecciona la especialidad
	@RequestMapping("/turno")
	public ModelAndView elegirEspecialidad() {
		
		ModelMap modelo = new ModelMap();
		
		List <Especialidad> listarEspecialidad = new ArrayList <Especialidad>();
		
		listarEspecialidad = servicioEspecialidad.consultarEspecialidades();
		
		modelo.put("listaEsp",listarEspecialidad);
		
		return new ModelAndView("elegir-especialidad", modelo);
	}
	
//	Paso 2 = selecciona el filtro de busqueda
	@RequestMapping("/turno/{especialidadId}")
	public ModelAndView elegirFiltro (@PathVariable Long especialidadId , HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("especialidadId", especialidadId);
		
		return new ModelAndView("filtro-medico-dia", modelo);
	}
	
//	Paso 3.a = filtra a todos los medicos segun la especialidad elegida
	@RequestMapping("/turno/{especialidadId}/medicos")
	public ModelAndView fitroMedico (@PathVariable Long especialidadId) {
		
		ModelMap modelo = new ModelMap();
		
		List <Medico> listaMedicos = servicioTurnos.listaDeMedicosPorEspecialidad(especialidadId);
		
		modelo.put("especialidadId",especialidadId);
		modelo.put("listaMedicos", listaMedicos);
		
		return new ModelAndView("medicos", modelo);
	}
	
//	Paso 3.b = seleccionaria la fecha en la cual desea solicitar el turno
	@RequestMapping("/turno/{especialidadId}/dias")
	public ModelAndView fitroDia (@PathVariable Long especialidadId) {
		
		ModelMap modelo = new ModelMap();
		
		//busca la lista de los dias de los medicos con esa especialidad
		List <DiasLaborales> listaDias = servicioTurnos.listaDeDiasDisponibles(especialidadId);
		Set<DiasLaborales> hs = new HashSet<>();
		
		//lo paso a set porque puede tocar valores repetidos, set los borra
		hs.addAll(listaDias);
		listaDias.clear();
		listaDias.addAll(hs);
		
		//convierto a lista de id de dias para usarlo en el calendario
		List <Long> idDias = new ArrayList<Long>();
		for(DiasLaborales dia : listaDias) {
			idDias.add(dia.getId());
		}				
		
		modelo.put("dias", idDias);
		
		return new ModelAndView("diasDeEspecialidad", modelo);
	}
	
	
//	Paso 4.a = selecciona la fecha del turno
	@RequestMapping("/turno/{especialidadId}/medico/{medicoId}")
	public ModelAndView elegirFecha (@PathVariable Long especialidadId, @PathVariable Long medicoId) {
		
		ModelMap modelo = new ModelMap();
		
		List <DiasLaborales> listaDeDias = new ArrayList<DiasLaborales>();
		
		listaDeDias = servicioMedico.buscarDiasLaborales(medicoId);
		//convierto a lista de id de dias para usarlo en el calendario
		
		List <Long> idDias = new ArrayList<Long>();
		for(DiasLaborales dia : listaDeDias) {
			idDias.add(dia.getId());
		}
		
		modelo.put("medicoId", medicoId);
		modelo.put("especialidadId",especialidadId);
		modelo.put("dias", idDias);
		
		return new ModelAndView("diasDelMedico", modelo);
	}
	
//	Paso 4.b = selecciona fecha segun el medico
	@RequestMapping("/turno/{especialidadId}/dia/{fecha}/{diaId}")
	public ModelAndView medicosDisponiblesPorDia (@PathVariable Long especialidadId, @PathVariable String fecha, @PathVariable Long diaId) {
		ModelMap modelo = new ModelMap();
		
		modelo.put("especialidadId", especialidadId);
		modelo.put("fecha", fecha);
		
		List <Medico> listaMedicosPorDia = servicioTurnos.listaDeMedicosDisponibles(especialidadId, diaId);
		
		modelo.put("listaDeMedicos",listaMedicosPorDia);
		
		return new ModelAndView("mostrar-medicos-dia", modelo);
	}
	
//	Paso 5.a = lista los turnos disponibles del medico en la fecha seleccionada a travez del filtro de Medico
	@RequestMapping(path="/turno/{especialidadId}/medico/{medicoId}/{fecha}")
	public ModelAndView obtenerListaDeTurnosDeMedico(@PathVariable Long especialidadId, @PathVariable Long medicoId, @PathVariable String fecha ){
		
		ModelMap modelo = new ModelMap();
		
		Medico medicoBuscado = servicioTurnos.buscarMedicoEspecifico(medicoId);
		
		List <String> listaTurnos = servicioTurnos.turnosDeMedicoEspecifico(medicoBuscado);
		List <String> listaTurnosDisponibles = servicioTurnos.turnosDisponibles(listaTurnos,especialidadId,medicoId,fecha);
		
		modelo.put("listaDeTurnos", listaTurnosDisponibles);
		modelo.put("especialidadId", especialidadId);
		modelo.put("medicoId", medicoId);
		modelo.put("fecha", fecha);
		modelo.put("medico", medicoBuscado.getNombre());
		
		return new ModelAndView("mostrar-turnos", modelo);
	}
	
//	Paso 5.b = lista los turnos disponibles del medico en la fecha seleccionada a travez del filtro de Dia
	@RequestMapping(path="/turno/{especialidadId}/dia/{fecha}/{diaId}/{medicoId}")
	public ModelAndView obtenerListaDeTurnosDeMedicoPorDia(@PathVariable Long especialidadId, @PathVariable String fecha, @PathVariable Long diaId, @PathVariable Long medicoId){
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("especialidadId", especialidadId);
		modelo.put("fecha", fecha);
		modelo.put("diaId", diaId);
		
		Medico medicoBuscado = servicioTurnos.buscarMedicoEspecifico(medicoId);
		List <String> listaTurnos = servicioTurnos.turnosDeMedicoEspecifico(medicoBuscado);
		List <String> listaTurnosDisponibles = servicioTurnos.turnosDisponibles(listaTurnos,especialidadId,medicoId,fecha);
		
		modelo.put("listaDeTurnos", listaTurnosDisponibles);
		
		return new ModelAndView("mostrar-turnos", modelo);
	}	

//  Paso 6 = guarda el turno con todas las especificaciones seleccionadas
	@RequestMapping(path= "/reservar-turno", method = RequestMethod.POST)
	public ModelAndView reservarTurno(TurnoViewModel turnoViewModel,HttpServletRequest request) {
		
		Long idUsuario = (Long)request.getSession().getAttribute("ID");
		
		ModelMap modelo = new ModelMap();
		
		Turno turno = new Turno();
		Medico medico = new Medico();
		Especialidad especialidad = new Especialidad();
		
		especialidad.setId(turnoViewModel.getEspecialidadId());
		
		medico.setId(turnoViewModel.getMedicoId());
		medico.setEspecialidad(especialidad);
		
		turno.setFecha(turnoViewModel.getFecha());
		turno.setHorario(turnoViewModel.getHorario());
		turno.setMedico(medico);
		
		servicioTurnos.guardarTurno(turno,idUsuario);

		modelo.put("turno",turnoViewModel);
		
		return new ModelAndView("turno-ok", modelo);
		
	}
	
	
//mostrar historia clinica paciente
	
		@RequestMapping(path= "/mostrarhistoriaclinica")
		public ModelAndView mostrarHistoriaClinica(HttpServletRequest request){
			ModelMap modelo = new ModelMap();
			//final Session session = sessionFactory.getCurrentSession();
			Long id = (Long)request.getSession().getAttribute("ID");
			//Long id = (Long) ((ServletRequest) session).getAttribute("ID");
			Long idPaciente = servicioPaciente.obtenerPacienteId(id);
			List<Turno> listaHistorial = servicioTurnos.mostrarHistoriaClinica(idPaciente);
			Paciente paciente = servicioTurnos.mostrarDatosPaciente(idPaciente);
			modelo.put("paciente",paciente);
			modelo.put("listahistorial", listaHistorial);
			return new ModelAndView("mostrarHistoriaClinica",modelo);
		}
		
		
// Parte de Descripscion del medico
		
		@RequestMapping(path="/turno/atendido/{turnoId}/{consultorioId}/{medicoId}")
		public ModelAndView obtenerTurnoAtendido(@PathVariable Long turnoId,@PathVariable Long consultorioId,@PathVariable Long medicoId){
		
			servicioTurnos.cambiarEstadoAtendido(turnoId);
			
			return new ModelAndView("redirect:/"+medicoId+"/index-medico/"+consultorioId);
		}
		
		
		
		@RequestMapping(path="/turno/guardarComentario/{turnoId}/{consultorioId}/{medicoId}/{estudio}/{descripcion}")
		public ModelAndView guardarComentario(@PathVariable Long turnoId ,@PathVariable Long consultorioId ,@PathVariable Long medicoId ,@PathVariable Long estudio ,@PathVariable String descripcion ){
			
			servicioTurnos.agregarDescripcion(turnoId,descripcion,estudio);
			
			return new ModelAndView("redirect:/"+medicoId+"/index-medico/"+consultorioId);		}
		
		

		@RequestMapping(path="/turno/guardarDerivacion/{consultorioId}/{medicoId}/{pacienteId}/{medicoADerivarId}")
		public ModelAndView guardarDerivacion(@PathVariable Long consultorioId,@PathVariable Long medicoId,@PathVariable Long pacienteId,@PathVariable Long medicoADerivarId){
			
			servicioTurnos.agregarDerivacion(pacienteId,medicoADerivarId);

			return new ModelAndView("redirect:/"+medicoId+"/index-medico/"+consultorioId);		}
		
		
}
