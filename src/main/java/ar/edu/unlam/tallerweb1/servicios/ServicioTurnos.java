package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Atencion;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface ServicioTurnos {
	
	List<Medico> consultarMedico();
	
	List <Medico> listaDeMedicosPorEspecialidad (Long especialidadId);

	List<String> turnosDeMedicoEspecifico(Medico medico);

	List<DiasLaborales> listaDeDiasDisponibles(Long especialidadId);
	
	Medico buscarMedicoEspecifico(Long id);

	List<Turno> listaTurnosPorMedico(Medico medico, String diaActual);

	List<String> turnosDisponibles(List<String> listaTurnos, Long especialidadId, Long medicoId, String fecha);

	Turno guardarTurno(Turno turno, Long idUsuario);
	
	void guardarTurnoRecepcionista(Turno turno);

	String diaActual();

	String diaSiguiente(Medico medico);
	
	List<Medico> listaDeMedicosDisponibles(Long especialidadId, Long diaId);
	
	List<Atencion> mostrarHistoriaClinica(Long id);
	
	Paciente mostrarDatosPaciente(Long id);

	void cambiarEstadoAtendido(Long id);

	void agregarDerivacion(Long pacienteId, Long medicoId);

	void agregarDescripcion(Long turnoId, String descripcion, Long estudio);

	List<Turno> listaDeDerivacion(Long usuarioId);

	Turno guardarDerivacion(Long turnoId, String fecha, String horario, Long especialidadId, Long medicoId);

	void guardarAtencion(String mensaje, Long pacienteId, Long medicoId, String fecha);

	List<Turno> listaTodosLosTurnos(Medico medico);

	List<Turno> listaTurnosManana(Medico medico, String diaSiguiente);
}


