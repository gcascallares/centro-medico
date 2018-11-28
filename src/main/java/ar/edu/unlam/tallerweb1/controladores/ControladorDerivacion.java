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
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.viewmodel.DerivacionViewModel;
import ar.edu.unlam.tallerweb1.controladores.viewmodel.TurnoViewModel;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.servicios.ServicioMedico;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;

@Controller
public class ControladorDerivacion {
	
	@Inject
	private ServicioTurnos servicioTurnos;
	
	@Inject
	private ServicioMedico servicioMedico;
	
// 			Derivaciones 
	
			@RequestMapping("/derivacion/{usuarioId}")
			public ModelAndView derivaciones(@PathVariable Long usuarioId){
				
				ModelMap modelo = new ModelMap();
				
				List <Turno> listaDeDerivaciones = servicioTurnos.listaDeDerivacion(usuarioId);
				
				modelo.put("listaDerivaciones", listaDeDerivaciones);

				return new ModelAndView("derivaciones", modelo);
				
			}
			
			
			@RequestMapping("/derivacion/{turnoId}/{especialidadId}/medico/{medicoId}")
			public ModelAndView elegirFechaParaDerivacion(@PathVariable Long turnoId ,@PathVariable Long especialidadId, @PathVariable Long medicoId) {
				
				ModelMap modelo = new ModelMap();
				
				List <DiasLaborales> listaDeDias = new ArrayList<DiasLaborales>();
				
				listaDeDias = servicioMedico.buscarDiasLaborales(medicoId);
				//convierto a lista de id de dias para usarlo en el calendario
				
				List <Long> idDias = new ArrayList<Long>();
				for(DiasLaborales dia : listaDeDias) {
					idDias.add(dia.getId());
				}
				
				modelo.put("medicoId", medicoId);
				modelo.put("especialidadId",especialidadId);
				modelo.put("dias", idDias);
				modelo.put("turnoId", turnoId);
				
				return new ModelAndView("diasDelMedicoDerivacion", modelo);
			}
			
			@RequestMapping("/derivacion/{turnoId}/{especialidadId}/medico/{medicoId}/{fecha}")
			public ModelAndView turnosDeLaDerivacion(@PathVariable Long turnoId, @PathVariable Long especialidadId, @PathVariable Long medicoId, @PathVariable String fecha ){
				
				ModelMap modelo = new ModelMap();
				
				Medico medicoBuscado = servicioTurnos.buscarMedicoEspecifico(medicoId);
				
				List <String> listaTurnos = servicioTurnos.turnosDeMedicoEspecifico(medicoBuscado);
				List <String> listaTurnosDisponibles = servicioTurnos.turnosDisponibles(listaTurnos,especialidadId,medicoId,fecha);
				
				modelo.put("listaDeTurnos", listaTurnosDisponibles);
				modelo.put("especialidadId", especialidadId);
				modelo.put("medicoId", medicoId);
				modelo.put("turnoId", turnoId);
				modelo.put("fecha", fecha);
				modelo.put("medico", medicoBuscado);
				
				return new ModelAndView("mostrar-turnos-derivacion", modelo);
			}
			
			@RequestMapping(path="/reservar-derivacion", method = RequestMethod.POST)
			public ModelAndView reservarDerivacion(DerivacionViewModel derivacionViewModel,HttpServletRequest request) {
				
				Long idUsuario = (Long)request.getSession().getAttribute("ID");
				
				ModelMap modelo = new ModelMap();
				
				Turno turno = new Turno();
				Medico medico = new Medico();
				Especialidad especialidad = new Especialidad();
				
				especialidad.setId(derivacionViewModel.getEspecialidadId());
				
				medico.setId(derivacionViewModel.getMedicoId());
				medico.setEspecialidad(especialidad);
				
				turno.setId(derivacionViewModel.getTurnoId());
				turno.setDerivado(0);
				turno.setFecha(derivacionViewModel.getFecha());
				turno.setHorario(derivacionViewModel.getHorario());
				turno.setMedico(medico);
				
				servicioTurnos.guardarDerivacion(turno, idUsuario);

				modelo.put("derivacion",derivacionViewModel);
				
				return new ModelAndView("derivacion-ok", modelo);
				
			}
			
}
