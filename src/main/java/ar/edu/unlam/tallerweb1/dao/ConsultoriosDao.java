package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.modelo.Consultorio;

public interface ConsultoriosDao {

	List<Consultorio> listaConsultorios();

	Consultorio buscarConsultorioEspecifico(Long consultorioId);

	void guardarConsultorio(Consultorio consultorio);

<<<<<<< HEAD
=======
	Consultorio buscarConsultorioPorMedico(Long medicoId);

>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
	
}
