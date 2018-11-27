package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Consultorio;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Estudio;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;
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
	
	
	@RequestMapping("/{medicoId}/index-medico")
	public ModelAndView elegirConsultorio(@PathVariable Long medicoId , HttpServletRequest request){
		
		ModelMap modelo = new ModelMap();
		List <Consultorio> listaConsultorios = new ArrayList <Consultorio>();
		listaConsultorios = servicioConsultorio.listaConsultorios();
	
		modelo.put("listaConsultorios", listaConsultorios);
		modelo.put("medicoId", medicoId);
		return new ModelAndView("mostrar-consultorios", modelo);
	
	}
	
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
	
	
}
