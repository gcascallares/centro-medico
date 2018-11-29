package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMedico;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;
	
	@Inject
	private ServicioMedico servicioMedico;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView inicio() {
		
		return new ModelAndView("redirect:/Iniciar");
		
	}


	@RequestMapping("/Iniciar")
	public ModelAndView irALogin() {

		ModelMap modelo = new ModelMap();
		
		Usuario usuario = new Usuario();
		
		modelo.put("usuario", usuario);

		return new ModelAndView("login", modelo);
	}
	
	@RequestMapping("/cerrarSesion")
	public ModelAndView cerrarSesion(HttpServletRequest request) {
		
		request.getSession().removeAttribute("ID");
		request.getSession().removeAttribute("ROL");
		
		ModelMap modelo = new ModelMap();
		Usuario usuario = new Usuario();
		
		modelo.put("usuario", usuario);
		
		return new ModelAndView("redirect:/Iniciar", modelo);
	}
	

	@RequestMapping(path = "/Inicio", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		
		ModelMap modelo = new ModelMap();

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		
		modelo.put("usuario", usuarioBuscado);
		
		if (usuarioBuscado != null) {
			
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			request.getSession().setAttribute("ID", usuarioBuscado.getId());
			
			switch(usuarioBuscado.getRol()) {
			
			case "paciente": return new ModelAndView("index", modelo);
			
			case "recepcionista": return new ModelAndView("buscadorPacientes", modelo);
			
			case "medico" : 
				Medico medico = servicioMedico.traerMedicoSegunUsuario(usuarioBuscado);
				return new ModelAndView("redirect:/"+medico.getId()+"/index-medico");
			}
		}
		 else {
			 
			// si el usuario no existe agrega un mensaje de error en el modelo.
			modelo.put("error", "Usuario o clave incorrecta");
		}
		
		return new ModelAndView("login", modelo);
	}
	
	@RequestMapping(path = "/Home")
	public ModelAndView IrAlHome(HttpServletRequest request) {
		
		Long idUsuario = (Long)request.getSession().getAttribute("ID");
		
		Usuario usuario = servicioLogin.consultarUsuario(idUsuario);
		
		ModelMap modelo = new ModelMap();			
		modelo.put("usuario", usuario);
			switch(request.getSession().getAttribute("ROL").toString()) {
			
			case "paciente": return new ModelAndView("index",modelo);
			
			case "recepcionista": return new ModelAndView("buscadorPacientes");
			
			case "medico" : 
				Medico medico = servicioMedico.traerMedicoSegunUsuario(usuario);
				return new ModelAndView("redirect:/"+medico.getId()+"/index-medico");
			}
		
		
		return new ModelAndView("index", modelo);
	}
}
