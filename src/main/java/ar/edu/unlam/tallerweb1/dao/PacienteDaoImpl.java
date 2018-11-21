package ar.edu.unlam.tallerweb1.dao;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("pacienteDao")
public class PacienteDaoImpl  implements PacienteDao{
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void guardarPaciente (Paciente paciente) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		session.save(paciente);
		
		
	}
	

	@Override
	public Long obtenerIdPaciente(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		Usuario usuario = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.like("id", id)).uniqueResult();
		
		return usuario.getPaciente().getId();
	}

}
