
package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

import org.hibernate.Session;
import org.junit.Test;
import org.junit.runner.Request;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.controladores.ControladorMedico;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;
import ar.edu.unlam.tallerweb1.servicios.ServicioTurnos;

public class MockitoTest {
	@Test
    @Transactional @Rollback(true)
    public void pruebaMostrarHistoriaClinica(){
		HttpServletRequest request = mock(HttpServletRequest.class);
		ServicioTurnos servicioTurnosMock = mock(ServicioTurnos.class);
		Long pacienteId = null;
		Paciente pacienteMock = mock(Paciente.class);
		HttpSession sessionMock = mock(HttpSession.class);
		Usuario usuarioMock = mock(Usuario.class);
		ControladorMedico controladorMedico = new ControladorMedico();
		controladorMedico.setServicioTurnos(servicioTurnosMock);
		when (servicioTurnosMock.mostrarDatosPaciente(pacienteId)).thenReturn(pacienteMock);
		when (request.getSession()).thenReturn(sessionMock);
		ModelAndView modelandview = controladorMedico.mostrarHistoriaClinica(pacienteId, request);
		
		assertThat(modelandview.getViewName()).isEqualTo("mostrarHistoriaClinicaDePaciente");

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
}
