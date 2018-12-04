package ar.edu.unlam.tallerweb1.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Consultorio;

public interface ServicioConsultorio {

	List <Consultorio> listaConsultorios();
	
<<<<<<< HEAD

	Consultorio buscarConsultorioEspecifico(Long consultorioId);


	void guardarConsultorio(Consultorio consultorio);
=======
	Consultorio buscarConsultorioEspecifico(Long consultorioId);

	void guardarConsultorio(Consultorio consultorio);

	Consultorio buscarConsultorioPorMedico(Long medicoId);
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git


}
