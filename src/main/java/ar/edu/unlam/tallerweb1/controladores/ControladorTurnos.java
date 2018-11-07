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
import org.springframework.web.servlet.ModelAndView;

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
	
	
	@RequestMapping(path="/turno/medico/", method = RequestMethod.POST)
	public ModelAndView obtenerListaDeTurnosDeMedico(@ModelAttribute("Medico") Medico medico){
		ModelMap modelo = new ModelMap();
		List <String> listaTurnos = servicioTurnos.turnosDeMedicoEspecifico(medico); 
		///faltan metodos para obtener los datos anteriores segun la especialidad y el medico.
		modelo.put("listaDeTurnos", listaTurnos);
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
	public ModelAndView elegirFiltro (@PathVariable Integer especialidadId , HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		modelo.put("especialidadId", especialidadId);
		///ya consegui el id de especialidad, ahora buscar los medicos con esa especialidad
		return new ModelAndView("filtro-medico-dia", modelo);
	}
	
	//Este controlador seria si funciona la vista que da error
	@RequestMapping("turno/medico/{especialidadId}")
	public ModelAndView fitroMedico (@PathVariable Integer especialidadId) {
		ModelMap modelo = new ModelMap();
		List <Medico> listaMedicos = servicioTurnos.listaDeMedicosPorEspecialidad(especialidadId);
		modelo.put("listaMedicos", listaMedicos);
		return new ModelAndView("medicos", modelo);
	}
	
	@RequestMapping(path= "/reservar-turno", method = RequestMethod.POST)
	public ModelAndView reservarTurno(@ModelAttribute("Turno") Turno turno) {
		ModelMap modelo = new ModelMap();
		modelo.put("turno", turno);
		///toda la logica de reservar el turno
		modelo.put("mensaje", "Su turno ha sido reservado con éxito!");
		return new ModelAndView("turno-ok", modelo);
	}
}
