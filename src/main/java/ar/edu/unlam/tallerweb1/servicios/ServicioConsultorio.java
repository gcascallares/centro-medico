<<<<<<< HEAD
package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Consultorio;

public interface ServicioConsultorio {

	List <Consultorio> listaConsultorios();
	
	void guardarConsultorio(Long consultorioId);
	
}
=======
package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Consultorio;

public interface ServicioConsultorio {

	List <Consultorio> listaConsultorios();
	

	Consultorio buscarConsultorioEspecifico(Long consultorioId);


	void guardarConsultorio(Consultorio consultorio);


}
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
