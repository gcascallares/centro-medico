package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;

@Repository("especialidadDao")
public class EspecialidadDaoImpl implements EspecialidadDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@Override
	public List <Especialidad> consultarEspecialidades(){
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Especialidad> listarEspecialidad = session.createCriteria(Especialidad.class).list();
		return listarEspecialidad;
	}

}
