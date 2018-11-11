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
		return new ModelAndView("mostrar-consultorios", modelo);
	
	}
	
	@RequestMapping("/index-medico/{consultorioId}")
	public ModelAndView inicioMedico(@PathVariable Long consultorioId , HttpServletRequest request){
		ModelMap modelo = new ModelMap();
		
//		Paciente paciente = new Paciente();
//		paciente = servicioPaciente.pacienteId(idPaciente);
//		
		List <Turno> listaTurnos = new ArrayList <Turno>();
		listaTurnos = servicioTurnos.listaTurnos();
		modelo.put("listaTurnos", listaTurnos);
 		//servicioConsultorio
		//String nombrePaciente = listaTurnos.get(0).getPaciente().getNombre();
		//modelo.put("nombrePaciente", nombrePaciente);
		//System.out.println(nombrePaciente);
		return new ModelAndView("inicio-medico", modelo);
	}
	
}
