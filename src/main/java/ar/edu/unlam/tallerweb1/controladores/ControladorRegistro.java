package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;


@Controller
public class ControladorRegistro {
	
	@Inject
	private ServicioRegistro servicioRegistro;
	
	//Mando el objeto vacio a la vista registrar en la cual se seteo los valores que tiene
	@RequestMapping("/Registrar")
	public ModelAndView iraRegistro(){
		ModelMap modelo = new ModelMap();
		Paciente paciente = new Paciente();
		modelo.put("paciente", paciente);
		return new ModelAndView("registrar", modelo);
	}
	
//	Rebibo el objeto cono los valores seteados y lo guardo en la base de datos
	@RequestMapping(path = "/registrarUsuario", method = RequestMethod.POST)
	public ModelAndView guardarPaciente(@ModelAttribute("paciente") Paciente paciente, HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		
		Usuario usuario = new Usuario();
		
		Paciente paciente2 = servicioRegistro.guardarPaciente(paciente);
		
		modelo.put("usuario", usuario);
		
		modelo.put("paciente", paciente2);
		
		return new ModelAndView("registrarUsuario", modelo);
	}

//  Para determinar la vista al levantar el entorno
	@RequestMapping(path = "/Iniciar", method = RequestMethod.POST)
	public ModelAndView irAHome(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();
		
		Usuario usuario2 = servicioRegistro.guardarUsuario(usuario);
		
		modelo.put("usuario", usuario2);
		
		return new ModelAndView("login", modelo);
	}


}
