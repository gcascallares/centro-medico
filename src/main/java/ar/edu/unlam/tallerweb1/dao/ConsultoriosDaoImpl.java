package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Consultorios;


@Repository("consultoriosDao")
public class ConsultoriosDaoImpl implements ConsultoriosDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public List<Consultorios> listaConsultorios() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Consultorios> listaConsultorios = session.createCriteria(Consultorios.class).list();
		return listaConsultorios;
		
	}
	


}