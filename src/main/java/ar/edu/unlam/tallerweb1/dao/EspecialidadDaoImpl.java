package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Estudio;

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
	
	@Override
	public List <Estudio> listaDeEstudios (Especialidad especialidad){
		
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		List <Estudio> listaDeEstudios = session.createCriteria(Estudio.class)
									 	.createAlias("especialidad","especialidadBuscada")
									 	.add(Restrictions.eq("especialidadBuscada.id",especialidad.getId()))
									 	.list();
		return listaDeEstudios;
	}
	
}
