package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioEspecialidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;

@Controller
public class ControladorTurnos {

	@Inject
	private ServicioTurnos servicioTurnos;
	
	@Inject
	private ServicioEspecialidad servicioEspecialidad;
	
	
	@RequestMapping(path="/obtener-turnos", method = RequestMethod.POST)
	public ModelAndView obtenerListaDeTurnos(@ModelAttribute("Turno") Turno turno){
		ModelMap modelo = new ModelMap();
		List <String> listaDeTurnos = new ArrayList <String>();
		int horaDesde = 15;
		int minutoDesde = 30;
		int horaHasta = 16;
		int minutoHasta = 30;
		int intervalo = 15;
		///faltan metodos para obtener los datos anteriores segun la especialidad y el medico.
		String medico = "Natalia Natalia"; ///DESPUES SE CONSTRUYE EL OBJETO MEDICO Y SE PASA AL MODELO EN VEZ DE SOLO EL NOMBRE
		listaDeTurnos = servicioTurnos.consultarTurnos(horaDesde, minutoDesde, horaHasta, minutoHasta, intervalo);
		modelo.put("listaDeTurnos", listaDeTurnos);
		modelo.put("nombreMedico", medico);
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
	public ModelAndView elegirFiltro(@PathVariable int especialidadId) {
		ModelMap modelo = new ModelMap();
		///ya consegui el id de especialidad, ahora buscar los medicos con esa especialidad
		return new ModelAndView("filtro-medico-dia", modelo);
	}
	
//	@RequestMapping(path= "/turno/{especialidadId}", method= RequestMethod.GET)
//	public ModelAndView elegirFiltro(@ModelAttribute("especialidad") int especialidadId) {
//		ModelMap modelo = new ModelMap();
//		return new ModelAndView("filtro-medico-dia", modelo);
//	}
	
	@RequestMapping("/botones")
	public ModelAndView prueba() {
		ModelMap modelo = new ModelMap();
		return new ModelAndView("filtro-medico-dia", modelo);
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
