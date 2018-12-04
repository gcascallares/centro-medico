package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

<<<<<<< HEAD
=======
import ar.edu.unlam.tallerweb1.modelo.Atencion;
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface TurnoDao {

	List<Turno> listaTurnosPorMedico(Medico medico, String diaActual);

	List<String> turnosDisponibles(List<String> listaTurnos, Long especialidadId, Long medicoId, String fecha);

<<<<<<< HEAD
	void guardarTurno(Turno turno, Long idUsuario);
	
	void guardarTurnoRecepcionista(Turno turno);

	List<DiasLaborales> listaDeDiasDisponibles(Long especialidadId);

	List<Medico> listaDeMedicosDisponibles(Long especialidadId, Long diaId);
	
	List<Turno> mostrarHistoriaClinica(Long id);
	
	Paciente mostrarDatosPaciente(Long id);

	void cambiarEstadoAtendido(Long id);

	void agregarDerivacion(Long pacienteId, Long idMedico);

	void agregarDescripcion(Long turnoId, String descripcion, Long estudio);

	List<Turno> listaDeDerivacion(Long usuarioId);

	void guardarDerivacion(Turno turno, Long idUsuario);
=======
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

	List<Turno> listaTurnosProxDiaLaboral(Medico medico,String diaSiguiente);

	List<Atencion> mostrarHistoriaClinicaDePaciente(Long pacienteId, Long medicoId);

	List<Turno> listaTurnosPorPaciente(Long pacienteId);

	Turno actualizarTurno(Long turnoId, String fecha, String horario);
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git

}
