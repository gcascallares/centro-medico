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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Consultorio;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Estudio;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioBuscadorPacientes;
import ar.edu.unlam.tallerweb1.servicios.ServicioConsultorio;
import ar.edu.unlam.tallerweb1.servicios.ServicioEspecialidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioMedico;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;

@Controller

public class ControladorMedico {

	@Inject
	private ServicioConsultorio servicioConsultorio;
	
	@Inject
	private ServicioTurnos servicioTurnos;
	
	@Inject
	private ServicioEspecialidad servicioEspecialidad;
	
	@Inject
	private ServicioMedico servicioMedico;
	
	@Inject
	private ServicioBuscadorPacientes servicioBuscadorPacientes;
	
	
	@RequestMapping("/{medicoId}/index-medico")
	public ModelAndView elegirConsultorio(@PathVariable Long medicoId , HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		List <Consultorio> listaConsultorios = new ArrayList <Consultorio>();
		listaConsultorios = servicioConsultorio.listaConsultorios();
	
		modelo.put("listaConsultorios", listaConsultorios);
		modelo.put("medicoId", medicoId);
		return new ModelAndView("mostrar-consultorios", modelo);
	
	}
	
	
	@SuppressWarnings("unused")
	@RequestMapping("/{medicoId}/index-medico/{consultorioId}")
	public ModelAndView inicioMedico(@PathVariable Long medicoId , @PathVariable Long consultorioId , HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		
		//Guarda el idMedico en el consultorio elejido
		Medico medico = servicioTurnos.buscarMedicoEspecifico(medicoId);
		Consultorio consultorio = servicioConsultorio.buscarConsultorioEspecifico(consultorioId);
		consultorio.setMedico(medico);
		servicioConsultorio.guardarConsultorio(consultorio);
		
		//Trae el dia actual
		String diaActual = servicioTurnos.diaActual();
		
		List <Turno> listaTurnos = new ArrayList <Turno>();
		
		//Trae lista Especialidades
		List <Especialidad> listaEspecialidad = new ArrayList <Especialidad>();
		listaEspecialidad = servicioEspecialidad.consultarEspecialidades();
		
		//Estudios
		Especialidad especialidad = servicioMedico.especialidadDelMedico(medicoId);
		List <Estudio> listaDeEstudios = servicioEspecialidad.listaDeEstudios(especialidad);
		
		listaTurnos = servicioTurnos.listaTurnosPorMedico(medico, diaActual);
		List<Medico> listaMedicos = servicioMedico.getMedicos();
		
		modelo.put("listaTurnos", listaTurnos);
		modelo.put("medico", medico);
		modelo.put("fecha",diaActual);
		modelo.put("consultorioId", consultorioId);
		modelo.put("listaMedicos", listaMedicos);
		modelo.put("listaEstudios",listaDeEstudios);
		
		return new ModelAndView("inicio-medico", modelo);
	}
	
	
	
	@RequestMapping("/generarAtencion")
	public ModelAndView buscadorDePacientes(){
		
		ModelMap modelo = new ModelMap();
		
		return new ModelAndView("atencionesMedico", modelo);
		
	}
	
	@RequestMapping(path="/atencionpacientespordni", method = RequestMethod.POST)
	public ModelAndView buscarPacientesPorDni(@RequestParam Long dni, HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		
		List <Paciente> listaPacientes = servicioBuscadorPacientes.listaPacientes(dni);
		modelo.put("listapacientes",listaPacientes);
		
		return new ModelAndView("listaPacientesAtencion", modelo);
	}
	
	@RequestMapping("/generarAtencion/{mensaje}/{idPaciente}")
	public ModelAndView guardarAtencion(@PathVariable String mensaje, @PathVariable Long idPaciente , HttpServletRequest request){
		
		String fecha = servicioTurnos.diaActual();
		
		Long medicoId = (Long) request.getSession().getAttribute("ID");
		
		servicioTurnos.guardarAtencion(mensaje, idPaciente, medicoId, fecha);

		return new ModelAndView("redirect:/generarAtencion");
		
	}
	
	@RequestMapping("/mostrarTurnosPorDia/{medicoId}")
	public ModelAndView mostrarTurnosPorDia(@PathVariable Long medicoId , HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		Medico medico = servicioTurnos.buscarMedicoEspecifico(medicoId);
		
		//Trae el dia siguiente
		String diaSiguiente = servicioTurnos.diaSiguiente();
		
		List <Turno> listaTodosLosTurnos = new ArrayList <Turno>();
		listaTodosLosTurnos = servicioTurnos.listaTodosLosTurnos(medico);
		
		modelo.put("listaTodosLosTurnos",listaTodosLosTurnos);
		
		return new ModelAndView("turnosMedico", modelo);
		
	}

	@RequestMapping("/mostrarTurnosDeMañana/{medicoId}")
	public ModelAndView mostrarTurnosDeMañana(@PathVariable Long medicoId , HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		Medico medico = servicioTurnos.buscarMedicoEspecifico(medicoId);
		
		//Trae el dia siguiente
		String diaSiguiente = servicioTurnos.diaSiguiente();
		
		List <Turno> listaTurnosManana = new ArrayList <Turno>();
		
		listaTurnosManana = servicioTurnos.listaTurnosManana(medico,diaSiguiente);
		
		modelo.put("listaTurnosManana",listaTurnosManana);
		
		return new ModelAndView("turnosDeManana", modelo);
		
	}
	
}
