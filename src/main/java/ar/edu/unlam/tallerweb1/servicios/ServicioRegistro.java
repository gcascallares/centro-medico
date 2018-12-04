package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface ServicioRegistro {
	
	void guardarPaciente(Paciente paciente);

	Usuario guardarUsuario(Paciente paciente);

}
