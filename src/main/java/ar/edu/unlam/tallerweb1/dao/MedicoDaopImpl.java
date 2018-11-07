package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

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
	
	@Override
	public List<Medico> listaDeMedicosPorEspecialidad (Integer especialidadId) {
		
	final Session session = sessionFactory.getCurrentSession();
	
	@SuppressWarnings("unchecked")
	List <Medico> listaMedicos = session.createCriteria(Medico.class)
								 .createAlias("especialidad","especialidadBuscada")
								 .add(Restrictions.eq("especialidadBuscada.id",especialidadId))
								 .list();
	return listaMedicos;

	}

}
