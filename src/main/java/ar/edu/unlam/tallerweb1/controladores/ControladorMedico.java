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

import ar.edu.unlam.tallerweb1.modelo.Atencion;
import ar.edu.unlam.tallerweb1.modelo.Consultorio;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
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
	
	
	public ServicioTurnos getServicioTurnos() {
		return servicioTurnos;
	}


	public void setServicioTurnos(ServicioTurnos servicioTurnos) {
		this.servicioTurnos = servicioTurnos;
	}


	@RequestMapping("/{medicoId}/index-medico")
	public ModelAndView elegirConsultorio(@PathVariable Long medicoId , HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		String usuarioRol = (String)request.getSession().getAttribute("ROL");
		
		if("medico".equals(usuarioRol)){
			Consultorio consultorio = servicioMedico.tieneConsultorio(medicoId);
			if(consultorio == null) {
			List <Consultorio> listaConsultorios = new ArrayList <Consultorio>();
			listaConsultorios = servicioConsultorio.listaConsultorios();
	
			modelo.put("listaConsultorios", listaConsultorios);
			modelo.put("medicoId", medicoId);
			return new ModelAndView("mostrar-consultorios", modelo);
			}
			else {
				return new ModelAndView("redirect:/"+medicoId+"/index-medico/"+consultorio.getId());
			}
			
		}
		else{
			return new ModelAndView("redirect:/Iniciar", modelo);
		}
	
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
	
	
	
	@RequestMapping("/generarAtencion/{medicoId}/{consultorioId}")
	public ModelAndView buscadorDePacientes(@PathVariable Long medicoId ,@PathVariable Long consultorioId , HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("medicoId", medicoId);
		modelo.put("consultorioId", consultorioId);
		
		return new ModelAndView("atencionesMedico", modelo);
		
	}
	
	@RequestMapping(path="/atencionpacientespordni/{medicoId}/{consultorioId}", method = RequestMethod.POST)
	public ModelAndView buscarPacientesPorDni(@PathVariable Long medicoId ,@PathVariable Long consultorioId ,@RequestParam Long dni, HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		
		modelo.put("medicoId", medicoId);
		modelo.put("consultorioId", consultorioId);
		
		List <Paciente> listaPacientes = servicioBuscadorPacientes.listaPacientes(dni);
		modelo.put("listapacientes",listaPacientes);
		
		return new ModelAndView("listaPacientesAtencion", modelo);
	}
	
	@RequestMapping("/generarAtencion/{mensaje}/{idPaciente}/{medicoId}/{consultorioId}")
	public ModelAndView guardarAtencion(@PathVariable Long medicoId ,@PathVariable Long consultorioId, @PathVariable String mensaje, @PathVariable Long idPaciente , HttpServletRequest request){
		
		String fecha = servicioTurnos.diaActual();
		
		servicioTurnos.guardarAtencion(mensaje, idPaciente, medicoId, fecha);

		return new ModelAndView("redirect:/generarAtencion/{medicoId}/{consultorioId}");
		
	}
	
	@RequestMapping("/mostrarTurnosPorDia/{medicoId}/{consultorioId}")
	public ModelAndView mostrarTurnosPorDia(@PathVariable Long medicoId ,@PathVariable Long consultorioId, HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		Medico medico = servicioTurnos.buscarMedicoEspecifico(medicoId);
		
		List <Turno> listaTodosLosTurnos = new ArrayList <Turno>();
		listaTodosLosTurnos = servicioTurnos.listaTodosLosTurnos(medico);
		
		modelo.put("listaTodosLosTurnos",listaTodosLosTurnos);
		
		return new ModelAndView("turnosMedico", modelo);
		
	}

	@RequestMapping("/mostrarTurnosDeProximoDiaLaboral/{medicoId}/{consultorioId}")
	public ModelAndView mostrarTurnosDeProximoDiaLaboral(@PathVariable Long medicoId ,@PathVariable Long consultorioId , HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		Medico medico = servicioTurnos.buscarMedicoEspecifico(medicoId);
		
		//Trae el dias Laborales
		List<DiasLaborales> diasLaborales = servicioMedico.buscarDiasLaborales(medicoId);
		medico.setDiasLaborales(diasLaborales);
		
		//Trae el dia siguiente
		String diaSiguiente = servicioTurnos.diaSiguiente(medico);
		
		List <Turno> listaTurnosProxDiaLaboral = new ArrayList <Turno>();
		
		listaTurnosProxDiaLaboral = servicioTurnos.listaTurnosProxDiaLaboral(medico,diaSiguiente);
		
		modelo.put("listaTurnosProxDiaLaboral",listaTurnosProxDiaLaboral);
				
		return new ModelAndView("turnosDeProximoDiaLaboral", modelo);
		
	}
	
	@RequestMapping("/medico/mostrarhistoriaclinica/{pacienteId}/{medicoId}/{consultorioId}")
	public ModelAndView mostrarHistoriaClinica(@PathVariable Long medicoId ,@PathVariable Long consultorioId, @PathVariable Long pacienteId , HttpServletRequest request){
			
		ModelMap modelo = new ModelMap();
		Paciente paciente = servicioTurnos.mostrarDatosPaciente(pacienteId);
		
		List<Atencion> historiaClinica = servicioTurnos.buscarHistoriaClinicaDePaciente(pacienteId,medicoId);		
		
		modelo.put("historiaClinica", historiaClinica);
		modelo.put("paciente", paciente);
		modelo.put("medicoId", medicoId);
		modelo.put("consultorioId", consultorioId);
		
		return new ModelAndView("mostrarHistoriaClinicaDePaciente", modelo);
		
	}
	
	
//	Metodos Getters y Setters

	public ServicioConsultorio getServicioConsultorio() {
		return servicioConsultorio;
	}


	public void setServicioConsultorio(ServicioConsultorio servicioConsultorio) {
		this.servicioConsultorio = servicioConsultorio;
	}


	public ServicioEspecialidad getServicioEspecialidad() {
		return servicioEspecialidad;
	}


	public void setServicioEspecialidad(ServicioEspecialidad servicioEspecialidad) {
		this.servicioEspecialidad = servicioEspecialidad;
	}


	public ServicioMedico getServicioMedico() {
		return servicioMedico;
	}


	public void setServicioMedico(ServicioMedico servicioMedico) {
		this.servicioMedico = servicioMedico;
	}


	public ServicioBuscadorPacientes getServicioBuscadorPacientes() {
		return servicioBuscadorPacientes;
	}


	public void setServicioBuscadorPacientes(ServicioBuscadorPacientes servicioBuscadorPacientes) {
		this.servicioBuscadorPacientes = servicioBuscadorPacientes;
	}
	
}
