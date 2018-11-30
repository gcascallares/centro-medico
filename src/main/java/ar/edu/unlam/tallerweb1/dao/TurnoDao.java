package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Atencion;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface TurnoDao {

	List<Turno> listaTurnosPorMedico(Medico medico, String diaActual);

	List<String> turnosDisponibles(List<String> listaTurnos, Long especialidadId, Long medicoId, String fecha);

	Turno guardarTurno(Turno turno, Long idUsuario);
	
	void guardarTurnoRecepcionista(Turno turno);

	List<DiasLaborales> listaDeDiasDisponibles(Long especialidadId);

	List<Medico> listaDeMedicosDisponibles(Long especialidadId, Long diaId);
	
	List<Atencion> mostrarHistoriaClinica(Long id);
	
	Paciente mostrarDatosPaciente(Long id);

	void cambiarEstadoAtendido(Long id);

	void agregarDerivacion(Long pacienteId, Long idMedico);

	void agregarDescripcion(Long turnoId, String descripcion, Long estudio);

	List<Turno> listaDeDerivacion(Long usuarioId);

	Turno guardarDerivacion(Long turnoId, String fecha, String horario, Long especialidadId, Long medicoId);

	List<Turno> listaTodosLosTurnos(Medico medico);

	List<Turno> listaTurnosManana(Medico medico,String diaSiguiente);

}
