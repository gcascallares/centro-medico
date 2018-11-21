package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Consultorio;


@Repository("consultoriosDao")
public class ConsultoriosDaoImpl implements ConsultoriosDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public List<Consultorio> listaConsultorios() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
	
		List <Consultorio> listaConsultorios = session.createCriteria(Consultorio.class)
		.add(Restrictions.isNull("medico"))
		.list();
		return listaConsultorios;
		
	}

	
	@Override
	public Consultorio buscarConsultorioEspecifico (Long consultorioId) {
		
	final Session session = sessionFactory.getCurrentSession();
	
	Consultorio consultorioEspecifico = (Consultorio) session.createCriteria (Consultorio.class)
							  .add(Restrictions.eq("id",consultorioId))
							  .uniqueResult();
	return consultorioEspecifico;

	}
	
	@Override
	public void guardarConsultorio(Consultorio consultorio) {
		
	final Session session = sessionFactory.getCurrentSession();
	
	session.update(consultorio);
	

	}
	

}