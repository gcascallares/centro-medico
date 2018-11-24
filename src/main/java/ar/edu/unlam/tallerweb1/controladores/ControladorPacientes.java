package ar.edu.unlam.tallerweb1.controladores;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscadorPacientes;

@Controller
public class ControladorPacientes {
	
	@Inject
	private ServicioBuscadorPacientes servicioBuscadorPacientes;
	
	@RequestMapping("/buscadorPaciente")
	public ModelAndView buscadorDePacientes(){
		ModelMap modelo = new ModelMap();
		return new ModelAndView("buscadorPacientes", modelo);
	}
	
	@RequestMapping(path="/buscarpacientespordni", method = RequestMethod.POST)
	public ModelAndView buscarPacientesPorDni(@RequestParam Long dni, HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		List <Paciente> listaPacientes = servicioBuscadorPacientes.listaPacientes(dni);
		modelo.put("listapacientes",listaPacientes);
		return new ModelAndView("listaPacientes", modelo);
	}
	
	@RequestMapping(path="/mostrarTurnosPaciente", method = RequestMethod.POST)
	public ModelAndView mostrarTurnosPaciente(@RequestParam Long id, HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		List <Turno> listaTurnos = servicioBuscadorPacientes.listaTurnos(id);
		modelo.put("listaturnos",listaTurnos);
		return new ModelAndView("listaTurnos", modelo);
	}

	@RequestMapping(path="/modificarestadoturno/{id}")
	public ModelAndView modificarEstadoTurno(@PathVariable Long id, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		servicioBuscadorPacientes.modificarEstadoTurno(id);
		return new ModelAndView("buscadorPacientes", modelo);
	}
	
	@RequestMapping(path="/modificarestadoturnorechazado/{id}")
	public ModelAndView modificarEstadoTurnoRechazado(@PathVariable Long id, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		servicioBuscadorPacientes.modificarEstadoTurnoRechazado(id);
		return new ModelAndView("buscadorPacientes", modelo);
	}
	
}
