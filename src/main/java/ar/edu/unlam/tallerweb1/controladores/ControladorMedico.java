package ar.edu.unlam.tallerweb1.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unlam.tallerweb1.modelo.Consultorios;
import ar.edu.unlam.tallerweb1.servicios.ServicioConsultorio;


@Controller

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
	
	
	@RequestMapping("/index-medico")
	public ModelAndView elegirConsultorio(){
		
		ModelMap modelo = new ModelMap();
		List <Consultorios> listaConsultorios = new ArrayList <Consultorios>();
		listaConsultorios = servicioConsultorio.listaConsultorios();
		modelo.put("listaConsultorios", listaConsultorios);
		return new ModelAndView("mostrar-consultorios", modelo);
	
	}
	
	
}
