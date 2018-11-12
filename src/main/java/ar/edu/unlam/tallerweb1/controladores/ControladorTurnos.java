<<<<<<< HEAD
package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.viewmodel.TurnoViewModel;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.servicios.ServicioEspecialidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;

@Controller
public class ControladorTurnos {

	@Inject
	private ServicioTurnos servicioTurnos;
	
	@Inject
	private ServicioEspecialidad servicioEspecialidad;
	
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
	@RequestMapping("/turno/{especialidadId}/medico")
	public ModelAndView fitroMedico (@PathVariable Long especialidadId) {
		ModelMap modelo = new ModelMap();
		List <Medico> listaMedicos = servicioTurnos.listaDeMedicosPorEspecialidad(especialidadId);
		modelo.put("especialidadId",especialidadId);
		modelo.put("listaMedicos", listaMedicos);
		return new ModelAndView("medicos", modelo);
	}
	
	
//	Paso 4.a = selecciona la fecha del turno
	@RequestMapping("/turno/{especialidadId}/medico/{medicoId}")
	public ModelAndView elegirFecha (@PathVariable Long especialidadId, @PathVariable Long medicoId) {
		ModelMap modelo = new ModelMap();
		modelo.put("medicoId", medicoId);
		modelo.put("especialidadId",especialidadId);
		return new ModelAndView("dias", modelo);
	}
	
<<<<<<< HEAD
	@RequestMapping(path="/reservar-turno", method = RequestMethod.POST)
=======
	
//	Paso 3.b = seleccionaria la fecha en la cual desea solicitar el turno
//	@RequestMapping("/turno/{especialidadId}/dia")
//	public ModelAndView fitroDia (@PathVariable Long especialidadId) {
//		ModelMap modelo = new ModelMap();
//		List <String> listaDias = servicioTurnos.listaDeDiasDisponibles(especialidadId);
//		modelo.put("listaDias", listaDias);
//		return new ModelAndView("dias", modelo);
//	}
	
//	Paso 5.a = lista los turnos disponibles del medico en la fecha seleccionada
	@RequestMapping(path="/turno/{especialidadId}/medico/{medicoId}/{fecha}")
	public ModelAndView obtenerListaDeTurnosDeMedico(@PathVariable Long especialidadId, @PathVariable Long medicoId, @PathVariable String fecha ){
		ModelMap modelo = new ModelMap();
		Medico medicoBuscado = servicioTurnos.buscarMedicoEspecifico(medicoId);
		List <String> listaTurnos = servicioTurnos.turnosDeMedicoEspecifico(medicoBuscado); 
		modelo.put("listaDeTurnos", listaTurnos);
		modelo.put("especialidadId", especialidadId);
		modelo.put("medicoId", medicoId);
		modelo.put("fecha", fecha);
		modelo.put("medico", medicoBuscado.getNombre());
		return new ModelAndView("mostrar-turnos", modelo);
	}
	
//  Paso 6 = guarda el turno con todas las especificaciones seleccionadas
	@RequestMapping(path= "/reservar-turno", method = RequestMethod.POST)
>>>>>>> ba5ed99b1850794e835eb2dc5d813106e3b232f6
	public ModelAndView reservarTurno(TurnoViewModel turno) {
		
		ModelMap modelo = new ModelMap();
		
		Long medicoId = turno.getMedicoId();
		Long especialidadId = turno.getEspecialidadId();
		String horario = turno.getHorario();
		String fecha = turno.getFecha();
		
		servicioTurnos.guardarTurno(especialidadId, medicoId, horario);

		modelo.put("medicoId", medicoId);
		modelo.put("especialidadId", especialidadId);
		modelo.put("horario", horario);
		modelo.put("fecha", fecha);
		
		return new ModelAndView("turno-ok", modelo);
		
	}
}
=======
package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.viewmodel.TurnoViewModel;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioEspecialidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;

@Controller
public class ControladorTurnos {

	@Inject
	private ServicioTurnos servicioTurnos;
	
	@Inject
	private ServicioEspecialidad servicioEspecialidad;
	
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
	@RequestMapping("/turno/{especialidadId}/medico")
	public ModelAndView fitroMedico (@PathVariable Long especialidadId) {
		ModelMap modelo = new ModelMap();
		List <Medico> listaMedicos = servicioTurnos.listaDeMedicosPorEspecialidad(especialidadId);
		modelo.put("especialidadId",especialidadId);
		modelo.put("listaMedicos", listaMedicos);
		return new ModelAndView("medicos", modelo);
	}
	
	
//	Paso 4.a = selecciona la fecha del turno
	@RequestMapping("/turno/{especialidadId}/medico/{medicoId}")
	public ModelAndView elegirFecha (@PathVariable Long especialidadId, @PathVariable Long medicoId) {
		ModelMap modelo = new ModelMap();
		modelo.put("medicoId", medicoId);
		modelo.put("especialidadId",especialidadId);
		return new ModelAndView("dias", modelo);
	}
	
	
//	Paso 3.b = seleccionaria la fecha en la cual desea solicitar el turno
//	@RequestMapping("/turno/{especialidadId}/dia")
//	public ModelAndView fitroDia (@PathVariable Long especialidadId) {
//		ModelMap modelo = new ModelMap();
//		List <String> listaDias = servicioTurnos.listaDeDiasDisponibles(especialidadId);
//		modelo.put("listaDias", listaDias);
//		return new ModelAndView("dias", modelo);
//	}
	
//	Paso 5.a = lista los turnos disponibles del medico en la fecha seleccionada
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
	
//  Paso 6 = guarda el turno con todas las especificaciones seleccionadas
	@RequestMapping(path= "/reservar-turno", method = RequestMethod.POST)
	public ModelAndView reservarTurno(TurnoViewModel turnoViewModel) {
		
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
		
		servicioTurnos.guardarTurno(turno);

		modelo.put("turno",turno);
		
		return new ModelAndView("turno-ok", modelo);
		
	}
}
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
