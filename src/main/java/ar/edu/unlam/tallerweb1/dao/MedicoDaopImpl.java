package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

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
	
	
	//Este funciona en caso de que se filtre por fecha
	@Override
	public List<Medico> listaDeMedicosPorEspecialidad (Long especialidadId) {
		
	final Session session = sessionFactory.getCurrentSession();
	
	@SuppressWarnings("unchecked")
	List <Medico> listaMedicos = session.createCriteria(Medico.class)
								 .createAlias("especialidad","especialidadBuscada")
								 .add(Restrictions.eq("especialidadBuscada.id",especialidadId))
								 .list();
	return listaMedicos;

	}
	
	//En caso de que se filtre por medico
	@Override
	public Medico MedicoEspecifico (Long id) {
		
	final Session session = sessionFactory.getCurrentSession();
	
	Medico medicoEspecifico = (Medico) session.createCriteria (Medico.class)
							  .add(Restrictions.eq("id",id))
							  .uniqueResult();
	return medicoEspecifico;

	}


	@Override
	public List<DiasLaborales> buscarDiasLaborales(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <DiasLaborales> lista = session.createCriteria(DiasLaborales.class)
		.createAlias("Medicos", "Medicos")
		.add(Restrictions.eq("Medicos.id",id))
		.list();
		
		return lista;
	}


	@Override
	public Medico buscarMedicoSegunUsuario (Usuario usuario) {
		final Session session = sessionFactory.getCurrentSession();
		Usuario usuarioBuscado = (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.like("id", usuario.getId())).uniqueResult();
		
		return usuarioBuscado.getMedico();
	}
	
	@Override
	public Especialidad especialidadDelMedico (Long medicoid) {
		
	final Session session = sessionFactory.getCurrentSession();
	
	Medico medicoEspecifico = (Medico) session.createCriteria (Medico.class)
							  .add(Restrictions.eq("id",medicoid))
							  .uniqueResult();
	
	return medicoEspecifico.getEspecialidad();

	}
	
}