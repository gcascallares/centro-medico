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
	
	
	/*@Override
	public void cargarEspecialidades() {
		Session session = sessionFactory.getCurrentSession();
		Especialidad radiologia = new Especialidad();
		Especialidad laboratorio = new Especialidad();
		Especialidad cardiologia = new Especialidad();
		
		radiologia.setNombreEspecialidad("Radiologia");
		cardiologia.setNombreEspecialidad("Cardiologia");
		laboratorio.setNombreEspecialidad("Laboratorio");
		List <Especialidad> listaEspecialidad = session.createCriteria(Especialidad.class).list();
		if(listaEspecialidad.isEmpty()) {
		session.save(laboratorio);
		session.save(radiologia);
		session.save(cardiologia);
		}
	}*/
	
	@Override
	public List <Especialidad> consultarEspecialidades(){
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Especialidad> listaEspecialidad = session.createCriteria(Especialidad.class).list();
		return listaEspecialidad;
	}

	
}
