package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;

@Repository("medicoDao")
public class MedicoDaopImpl implements MedicoDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public List<Medico> consultarMedico() {
		
	final Session session = sessionFactory.getCurrentSession();
	
	@SuppressWarnings("unchecked")
	List <Medico> listaMedicos = session.createCriteria(Medico.class).list();
	return listaMedicos;

	}

}
