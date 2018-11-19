package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Paciente;

@Repository("pacienteDao")
public class PacienteDaoImpl  implements PacienteDao{
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Paciente guardarPaciente (Paciente paciente) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Paciente paciente2 = paciente;
		
		session.save(paciente2);
		
		return paciente2;
		
	}

}
