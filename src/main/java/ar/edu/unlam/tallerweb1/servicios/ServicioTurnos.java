package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;


public interface ServicioTurnos {
	
	List<String> consultarTurnos(int horaDesde,int minutoDesde,int horaHasta,int minutoHasta,int intervalo);


}
