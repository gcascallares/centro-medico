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
public class ControladorPacientes {
	
	
	@Inject
	private ServicioEspecialidad servicioEspecialidad;
	
	@Inject
	private ServicioTurnos servicioTurnos;
	
	@Inject
	private ServicioBuscadorPacientes servicioBuscadorPacientes;
	
	@Inject
	private ServicioMedico servicioMedico;
	
	@Inject
	private ServicioPaciente servicioPaciente;
	
	@RequestMapping("/buscadorPaciente")
	public ModelAndView buscadorDePacientes(HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		String usuarioRol = (String)request.getSession().getAttribute("ROL");
		if("recepcionista".equals(usuarioRol)){
			return new ModelAndView("buscadorPacientes", modelo);
		}
		else{
			return new ModelAndView("redirect:/Iniciar", modelo);
		}
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
		modelo.put("idPaciente",id);
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
	
	@RequestMapping(path="/sacarTurno/{idPaciente}")
	public ModelAndView recepcionistaTurnoElegirEspecialidad(@PathVariable Long idPaciente, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		List <Especialidad> listarEspecialidad = new ArrayList <Especialidad>();
		listarEspecialidad = servicioEspecialidad.consultarEspecialidades();
		modelo.put("listaEsp",listarEspecialidad);
		modelo.put("idPaciente",idPaciente);
		return new ModelAndView("recepcionista-elegir-especialidad", modelo);
	}
	
	@RequestMapping (path="/elegirmedico/{idPaciente}/{especialidadId}")
	public ModelAndView recepcionistaElegirMedico(@PathVariable Long idPaciente, @PathVariable Long especialidadId, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		modelo.put("idPaciente",idPaciente);
		modelo.put("especialidadId",especialidadId);
		List <Medico> listaMedicos = servicioTurnos.listaDeMedicosPorEspecialidad(especialidadId);
		modelo.put("listaMedicos", listaMedicos);
		return new ModelAndView("recepcionista-elegir-medico", modelo);
	}
	
	@RequestMapping (path = "/elegirdia/{idPaciente}/{especialidadId}/{medicoId}")
	public ModelAndView recepcionistaElegirDia(@PathVariable Long idPaciente, @PathVariable Long especialidadId, @PathVariable Long medicoId, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		modelo.put("idPaciente",idPaciente);
		modelo.put("especialidadId",especialidadId);
		modelo.put("medicoId", medicoId);
	List <DiasLaborales> listaDeDias = new ArrayList<DiasLaborales>();
		listaDeDias = servicioMedico.buscarDiasLaborales(medicoId);
		//convierto a lista de id de dias para usarlo en el calendario
		List <Long> idDias = new ArrayList<Long>();
		for(DiasLaborales dia : listaDeDias) {
			idDias.add(dia.getId());
		}
		modelo.put("dias", idDias);
		return new ModelAndView("recepcionista-elegir-diasMedico", modelo);
	}
	
	@RequestMapping (path = "/elegirhorario/{idPaciente}/{especialidadId}/{medicoId}/{fecha}")
	public ModelAndView recepcionistaElegirHora(@PathVariable Long idPaciente, @PathVariable Long especialidadId, @PathVariable Long medicoId,@PathVariable String fecha, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		modelo.put("paciente_id",idPaciente);
		modelo.put("especialidadId",especialidadId);
		modelo.put("medico_id", medicoId);
		modelo.put("fecha", fecha);
		
		Medico medicoBuscado = servicioTurnos.buscarMedicoEspecifico(medicoId);
		List <String> listaTurnos = servicioTurnos.turnosDeMedicoEspecifico(medicoBuscado);
		List <String> listaTurnosDisponibles = servicioTurnos.turnosDisponibles(listaTurnos,especialidadId,medicoId,fecha);
		modelo.put("listaDeTurnos", listaTurnosDisponibles);
		modelo.put("medico", medicoBuscado.getNombre());
		Turno turno = new Turno();
		modelo.put("turno", turno);
		return new ModelAndView("recepcionista-elegir-horaMedico", modelo);
	}
	
	@RequestMapping (path = "/recepcionistareservarturno/{medico_id}/{paciente_id}", method = RequestMethod.POST)
	public ModelAndView recepcionistaReservarTurno(@PathVariable Long paciente_id, @PathVariable Long medico_id,@ModelAttribute("turno") Turno turno, HttpServletRequest request) {
		ModelMap modelo = new ModelMap();
		Medico medico = servicioTurnos.buscarMedicoEspecifico(medico_id);
		Paciente paciente = servicioPaciente.obtenerPaciente(paciente_id);
		turno.setPaciente(paciente);
		turno.setMedico(medico);
		servicioTurnos.guardarTurnoRecepcionista(turno);
		return new ModelAndView("buscadorPacientes", modelo);
	}
}
