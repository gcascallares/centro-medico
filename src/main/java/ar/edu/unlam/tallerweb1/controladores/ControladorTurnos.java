package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioEspecialidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;

@Controller
public class ControladorTurnos {

	@Inject
	private ServicioTurnos servicioTurnos;
	
	@Inject
	private ServicioEspecialidad servicioEspecialidad;
	
	
	@RequestMapping("/obtener-turnos")
	public ModelAndView obtenerListaDeTurnos() {
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
	
	@RequestMapping("/elegir-especialidad")
	public ModelAndView elegirEspecialidad() {
		ModelMap modelo = new ModelMap();
		List <Especialidad> listaEspecialidad = new ArrayList <Especialidad>();
		servicioEspecialidad.cargarEspecialidades();
		listaEspecialidad = servicioEspecialidad.consultarEspecialidades();
		modelo.put("listaEsp",listaEspecialidad);
		return new ModelAndView("elegir-especialidad", modelo);
	}
	
	@RequestMapping("/reservar-turno")
	public ModelAndView reservarTurno() {
		ModelMap modelo = new ModelMap();
		///toda la logica de reservar el turno
		modelo.put("mensaje", "Su turno ha sido reservado con éxito!");
		return new ModelAndView("turno-ok", modelo);
	}
	
	/*@RequestMapping("/validar-especialidad")
	public ModelAndView validarEspecialidad() {
		
		ModelMap modelo = new ModelMap();
		return new ModelAndView("elegir-especialidad", modelo);
	}*/
}
