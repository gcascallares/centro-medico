package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Consultorios;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioConsultorio;
import ar.edu.unlam.tallerweb1.servicios.ServicioEspecialidad;



public class ControladorMedico {

	@Inject
	private ServicioConsultorio servicioConsultorio;
	
//	@RequestMapping("/login-medico")
//	public ModelAndView irALogin() {
//
//		ModelMap modelo = new ModelMap();
//		Usuario usuario = new Usuario();
//		modelo.put("usuario", usuario);
//		return new ModelAndView("login-medico", modelo);
//		
//	}
	
	
		
	@RequestMapping("/indexMedico")
	public ModelAndView elegirConsultorio(){
		
		ModelMap modelo = new ModelMap();
		List <Consultorios> listaConsultorios = new ArrayList <Consultorios>();
		listaConsultorios = servicioConsultorio.listaConsultorios();
		modelo.put("listaConsultorios", listaConsultorios);
		return new ModelAndView("mostrar-consultorios", modelo);
	
	}
	
	
}
