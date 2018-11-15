package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Consultorio;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioConsultorio;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;


@Controller

public class ControladorMedico {

	@Inject
	private ServicioConsultorio servicioConsultorio;
	
	@Inject
	private ServicioTurnos servicioTurnos;
	
	
	
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
		
		listaTurnos = servicioTurnos.listaTurnosPorMedico(medico, diaActual);
		modelo.put("listaTurnos", listaTurnos);
		modelo.put("medico", medico);
		modelo.put("fecha",diaActual);
		return new ModelAndView("inicio-medico", modelo);
	}
	
	
}
