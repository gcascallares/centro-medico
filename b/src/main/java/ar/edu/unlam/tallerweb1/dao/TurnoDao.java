package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Turno;

public interface TurnoDao {
	
	void guardarTurno (Long especialidadId, Long medicoId, String horario);

}
