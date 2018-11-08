package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@RequestMapping(path="/turno/{especialidadId}/medico/{medicoId}")
	public ModelAndView obtenerListaDeTurnosDeMedico(@PathVariable Long especialidadId,@PathVariable Long medicoId){
		ModelMap modelo = new ModelMap();
		Medico medicoBuscado = servicioTurnos.buscarMedicoEspecifico(medicoId);
		List <String> listaTurnos = servicioTurnos.turnosDeMedicoEspecifico(medicoBuscado); 
		modelo.put("listaDeTurnos", listaTurnos);
		modelo.put("especialidadId", especialidadId);
		modelo.put("medicoId", medicoId);
		modelo.put("medico", medicoBuscado.getNombre());
		return new ModelAndView("mostrar-turnos", modelo);
	}
	
	@RequestMapping("/turno")
	public ModelAndView elegirEspecialidad() {
		ModelMap modelo = new ModelMap();
		List <Especialidad> listaEspecialidad = new ArrayList <Especialidad>();
		listaEspecialidad = servicioEspecialidad.consultarEspecialidades();
		modelo.put("listaEsp",listaEspecialidad);
		return new ModelAndView("elegir-especialidad", modelo);
	}
	
	@RequestMapping("/turno/{especialidadId}")
	public ModelAndView elegirFiltro (@PathVariable Long especialidadId , HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		modelo.put("especialidadId", especialidadId);
		///ya consegui el id de especialidad, ahora buscar los medicos con esa especialidad
		return new ModelAndView("filtro-medico-dia", modelo);
	}
	
	//Este controlador seria si funciona la vista que da error
	@RequestMapping("/turno/{especialidadId}/medico")
	public ModelAndView fitroMedico (@PathVariable Long especialidadId) {
		ModelMap modelo = new ModelMap();
		List <Medico> listaMedicos = servicioTurnos.listaDeMedicosPorEspecialidad(especialidadId);
		modelo.put("especialidadId",especialidadId);
		modelo.put("listaMedicos", listaMedicos);
		return new ModelAndView("medicos", modelo);
	}
	
	@RequestMapping("/turno/{especialidadId}/dia")
	public ModelAndView fitroDia (@PathVariable Long especialidadId) {
		ModelMap modelo = new ModelMap();
		List <String> listaDias = servicioTurnos.listaDeDiasDisponibles(especialidadId);
		modelo.put("listaDias", listaDias);
		return new ModelAndView("dias", modelo);
	}
	
	@RequestMapping(path= "/reservar-turno", method = RequestMethod.POST)
	public ModelAndView reservarTurno(TurnoViewModel turno) {
		
		ModelMap modelo = new ModelMap();
		
		Long medicoId = turno.getMedicoId();
		Long especialidadId = turno.getEspecialidadId();
		String horario = turno.getHorario();
		
		servicioTurnos.guardarTurno(especialidadId, medicoId, horario);
		
		///hacer metodos para obtener MEDICO, ESPECIALIDAD, y llenar el objeto turno para despues 
		/// asignarlo a la bdd
		
		modelo.put("medicoId", medicoId);
		modelo.put("especialidadId", especialidadId);
		modelo.put("horario", horario);
		
		return  new ModelAndView("turno-ok", modelo);
		
	}
}
