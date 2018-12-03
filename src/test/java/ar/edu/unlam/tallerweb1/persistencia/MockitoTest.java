
package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.Request;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorMedico;
import ar.edu.unlam.tallerweb1.controladores.ControladorPacientes;
import ar.edu.unlam.tallerweb1.controladores.ControladorRegistro;
import ar.edu.unlam.tallerweb1.controladores.ControladorTurnos;
import ar.edu.unlam.tallerweb1.modelo.Atencion;
import ar.edu.unlam.tallerweb1.modelo.Consultorio;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Estudio;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioConsultorio;
import ar.edu.unlam.tallerweb1.servicios.ServicioEspecialidad;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioMedico;
import ar.edu.unlam.tallerweb1.servicios.ServicioRegistro;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;

public class MockitoTest {
	
	@SuppressWarnings("unchecked")
	@Test
    @Transactional @Rollback(true)
    public void pruebaMostrarHistoriaClinica(){
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		ServicioTurnos servicioTurnosMock = mock(ServicioTurnos.class);
		List<Atencion> historiaClinica = mock(List.class);
		Long pacienteId = null;
		Long medicoId = null;
		Long consultorioId = null;
		Paciente pacienteMock = mock(Paciente.class);
		HttpSession sessionMock = mock(HttpSession.class);
		Usuario usuarioMock = mock(Usuario.class);
		ControladorMedico controladorMedico = new ControladorMedico();
		
		controladorMedico.setServicioTurnos(servicioTurnosMock);
		when(servicioTurnosMock.buscarHistoriaClinicaDePaciente(pacienteId, medicoId)).thenReturn(historiaClinica);
		when (servicioTurnosMock.mostrarDatosPaciente(pacienteId)).thenReturn(pacienteMock);
		when (request.getSession()).thenReturn(sessionMock);
		ModelAndView modelandview = controladorMedico.mostrarHistoriaClinica(medicoId,consultorioId,pacienteId, request);
		
		assertThat(modelandview.getViewName()).isEqualTo("mostrarHistoriaClinicaDePaciente");
		
		assertThat(modelandview.getModelMap().get("historiaClinica")).isEqualTo(historiaClinica);
		assertThat(modelandview.getModelMap().get("paciente")).isEqualTo(pacienteMock);
		assertThat(modelandview.getModelMap().get("medicoId")).isEqualTo(medicoId);
		assertThat(modelandview.getModelMap().get("consultorioId")).isEqualTo(consultorioId);
		

    }
	
	/*@Test
    @Transactional @Rollback(true)
    public void pruebaNull(){
		HttpServletRequest httpServletRequest = mock(HttpServletRequest.class);
		ServicioLogin servicioLoginMock = mock(ServicioLogin.class);
		Session sessionMock = mock(Session.class);
		Usuario usuarioMock = mock(Usuario.class);
		ControladorLogin controladorLogin = new ControladorLogin();
		controladorLogin.setServicioLogin(servicioLoginMock);
		when (servicioLoginMock.consultarUsuario(usuarioMock)).thenReturn(null);
		
		ModelAndView modelandview = controladorLogin.validarLogin(usuarioMock, httpServletRequest);
		
		assertThat(modelandview.getViewName()).isEqualTo("login");
    }*/
	
	@Test
    @Transactional @Rollback(true)
	 public void pruebaLoginRolRecepcionista(){
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		HttpSession sessionMock = mock(HttpSession.class);
		ControladorPacientes controladorPaciente = new ControladorPacientes();
		String usuarioRol = "recepcionista";
		when (requestMock.getSession()).thenReturn(sessionMock);
		when (requestMock.getSession().getAttribute("ROL")).thenReturn(usuarioRol);
		ModelAndView modelandview = controladorPaciente.buscadorDePacientes(requestMock);
		assertThat(modelandview.getViewName()).isEqualTo("buscadorPacientes");
	}
	
	@SuppressWarnings("unchecked")
	@Test
    @Transactional @Rollback(true)
    public void obtenerListaDeTurnosDeMedico(){
		
		HttpServletRequest request = mock(HttpServletRequest.class);
		ServicioTurnos servicioTurnosMock = mock(ServicioTurnos.class);
		Long usuarioId = null;
		Long medicoId = null;
		Long especialidadId = null;
		String fecha = "";
		Medico medicoMock = mock(Medico.class);
		List<String> listaTurnos = mock(List.class);
		List<String> listaTurnosDisponibles = mock(List.class);
		HttpSession sessionMock = mock(HttpSession.class);
		ControladorTurnos controladorTurnos = new ControladorTurnos();
		controladorTurnos.setServicioTurnos(servicioTurnosMock);
		
		when (request.getSession()).thenReturn(sessionMock);
		when (servicioTurnosMock.buscarMedicoEspecifico(medicoId)).thenReturn(medicoMock);
		when (servicioTurnosMock.turnosDeMedicoEspecifico(medicoMock)).thenReturn(listaTurnos);
		when (servicioTurnosMock.turnosDisponibles(listaTurnos, especialidadId, medicoId, fecha)).thenReturn(listaTurnosDisponibles);
		when (request.getSession().getAttribute("ID")).thenReturn(usuarioId);
		ModelAndView modelandview = controladorTurnos.obtenerListaDeTurnosDeMedico(especialidadId, medicoId, fecha, request);
		
		assertThat(modelandview.getViewName()).isEqualTo("mostrar-turnos");
		
		assertThat(modelandview.getModelMap().get("medico")).isEqualTo(medicoMock.getNombre());
		assertThat(modelandview.getModelMap().get("listaDeTurnos")).isEqualTo(listaTurnosDisponibles);
		assertThat(modelandview.getModelMap().get("especialidadId")).isEqualTo(especialidadId);
		assertThat(modelandview.getModelMap().get("medicoId")).isEqualTo(medicoId);
		assertThat(modelandview.getModelMap().get("fecha")).isEqualTo(fecha);
    }
	
	@Test
    @Transactional @Rollback(true)
    public void pruebaQueElPacienteSeRegistra(){
		
    	ServicioRegistro servicioRegistroMock = mock(ServicioRegistro.class);
    	HttpServletRequest requesMock = mock(HttpServletRequest.class);
    	Usuario usuarioMock = mock (Usuario.class);
    	Paciente pacienteMock = mock(Paciente.class);
    	
    	ControladorRegistro controladorRegistro = new ControladorRegistro();
    	
    	controladorRegistro.setServicioRegistro(servicioRegistroMock);
    	
    	ModelAndView modelandview = controladorRegistro.guardarPaciente(pacienteMock, requesMock);
    	
    	when(servicioRegistroMock.guardarUsuario(pacienteMock)).thenReturn(usuarioMock);
    	
    	assertThat(modelandview.getViewName()).isEqualTo("registrarUsuario");
    	
    }
	
	@SuppressWarnings({ "unchecked", "unused" })
	@Test
    @Transactional @Rollback(true)
    public void pruebaQuePruebaInicioDelMedico(){
		
		HttpServletRequest requestMock = mock(HttpServletRequest.class);
		ControladorMedico controladorMedico = new ControladorMedico();
		
		Medico medicoMock = mock(Medico.class);
		Consultorio consultorioMock = mock(Consultorio.class);
		Especialidad especialidadMock = mock(Especialidad.class);
				
		ServicioConsultorio servicioConsultorioMock= mock(ServicioConsultorio.class);
		ServicioTurnos servicioTurnosMock = mock(ServicioTurnos.class);
		ServicioEspecialidad servicioEspecialidadMock = mock(ServicioEspecialidad.class);
		ServicioMedico servicioMedicoMock = mock(ServicioMedico.class);
		
		controladorMedico.setServicioConsultorio(servicioConsultorioMock);
		controladorMedico.setServicioEspecialidad(servicioEspecialidadMock);
		controladorMedico.setServicioTurnos(servicioTurnosMock);
		controladorMedico.setServicioMedico(servicioMedicoMock);
		
		Long medicoId = medicoMock.getId();
		Long consultorioId = consultorioMock.getId();
		
		when(servicioTurnosMock.buscarMedicoEspecifico(medicoId)).thenReturn(medicoMock);
		
		when(servicioConsultorioMock.buscarConsultorioEspecifico(consultorioId)).thenReturn(consultorioMock);

		consultorioMock.setMedico(medicoMock);
		
		String diaActual = servicioTurnosMock.diaActual();
		
		when(servicioTurnosMock.diaActual()).thenReturn(diaActual);
		
		List <Turno> listaTurnosMock = mock(List.class);
		List <Especialidad> listaEspecialidadMock = mock(List.class);
		List <Estudio> listaDeEstudiosMock = mock(List.class);
		List <Medico> listaDeMedicosMock = mock(List.class);
		
		when(servicioMedicoMock.especialidadDelMedico(medicoId)).thenReturn(especialidadMock);
		
		when(servicioTurnosMock.listaTurnosPorMedico(medicoMock, diaActual)).thenReturn(listaTurnosMock);
		
		when(servicioEspecialidadMock.consultarEspecialidades()).thenReturn(listaEspecialidadMock);
		
		when(servicioEspecialidadMock.listaDeEstudios(especialidadMock)).thenReturn(listaDeEstudiosMock);
		
		when(servicioMedicoMock.getMedicos()).thenReturn(listaDeMedicosMock);
		
		ModelAndView modelAndViewMock = controladorMedico.inicioMedico(medicoId, consultorioId, requestMock);
		
		assertThat(modelAndViewMock.getModelMap().get("listaTurnos")).isEqualTo(listaTurnosMock);
		
		assertThat(modelAndViewMock.getModelMap().get("medico")).isEqualTo(medicoMock);
		
		assertThat(modelAndViewMock.getModelMap().get("fecha")).isEqualTo(diaActual);
		
		assertThat(modelAndViewMock.getModelMap().get("consultorioId")).isEqualTo(consultorioId);
		
		assertThat(modelAndViewMock.getModelMap().get("listaMedicos")).isEqualTo(listaDeMedicosMock);
		
		assertThat(modelAndViewMock.getModelMap().get("listaEstudios")).isEqualTo(listaDeEstudiosMock);
		
		assertThat(modelAndViewMock.getViewName()).isEqualTo("inicio-medico");
	}
	
}
