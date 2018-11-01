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
	
	Medico medico1 = new Medico();
	
	medico1.setNombre("Dr. Rodriguez Juan");
	medico1.setHoraDesde(15);
	medico1.setMinutoDesde(30);
	medico1.setHoraHasta(16);
	medico1.setMinutoHasta(30);
	
	session.save(medico1);

	@SuppressWarnings("unchecked")
	List <Medico> listaMedicos = session.createCriteria(Medico.class).list();
	return listaMedicos;

	}

}
