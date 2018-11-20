package ar.edu.unlam.tallerweb1.controladores;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

@Controller
public class ControladorLogin {

	@Inject
	private ServicioLogin servicioLogin;
	
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
	

	@RequestMapping(path = "/Inicio", method = RequestMethod.POST)
	public ModelAndView validarLogin(@ModelAttribute("usuario") Usuario usuario, HttpServletRequest request) {
		
		ModelMap model = new ModelMap();

		Usuario usuarioBuscado = servicioLogin.consultarUsuario(usuario);
		
		if (usuarioBuscado != null) {
			
			request.getSession().setAttribute("ROL", usuarioBuscado.getRol());
			
			switch(usuarioBuscado.getRol()) {
			
			case "paciente": return new ModelAndView("index");
			
			case "recepcionista": return new ModelAndView("buscadorPacientes");
			
			}
		}
		 else {
			 
			// si el usuario no existe agrega un mensaje de error en el modelo.
			model.put("error", "Usuario o clave incorrecta");
		}
		
		return new ModelAndView("login", model);
	}
}
