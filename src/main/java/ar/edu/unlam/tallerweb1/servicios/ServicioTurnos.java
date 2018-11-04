package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Medico;


public interface ServicioTurnos {
	
	List<String> consultarTurnos(int horaDesde,int minutoDesde,int horaHasta,int minutoHasta,int intervalo);

	List<Medico> consultarMedico();

}
