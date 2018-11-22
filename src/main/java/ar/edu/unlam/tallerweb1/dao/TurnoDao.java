package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

public interface TurnoDao {

	List<Turno> listaTurnosPorMedico(Medico medico, String diaActual);

	List<String> turnosDisponibles(List<String> listaTurnos, Long especialidadId, Long medicoId, String fecha);

	void guardarTurno(Turno turno);

	List<DiasLaborales> listaDeDiasDisponibles(Long especialidadId);

	List<Medico> listaDeMedicosDisponibles(Long especialidadId, Long diaId);
	
	List<Turno> mostrarHistoriaClinica(Long id);
	
	Paciente mostrarDatosPaciente(Long id);

	void cambiarEstadoAtendido(Long id);

	void agregarDescripcion(Long turnoId, String descripcion);

}
