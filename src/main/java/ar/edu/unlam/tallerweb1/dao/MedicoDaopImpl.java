package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Atencion;
import ar.edu.unlam.tallerweb1.modelo.Consultorio;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

@Repository("medicoDao")
public class MedicoDaopImpl implements MedicoDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> consultarMedico() {
		
	final Session session = sessionFactory.getCurrentSession();
	
	List <Medico> listaMedicos = session.createCriteria(Medico.class)
								 .list();
	
	return listaMedicos;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> listaDeMedicosPorEspecialidad (Long especialidadId) {
		
	final Session session = sessionFactory.getCurrentSession();
	
	List <Medico> listaMedicos = session.createCriteria(Medico.class)
								 .createAlias("especialidad","especialidadBuscada")
								 .add(Restrictions.eq("especialidadBuscada.id",especialidadId))
								 .list();
	return listaMedicos;

	}
	
	@Override
	public Medico MedicoEspecifico (Long id) {
		
	final Session session = sessionFactory.getCurrentSession();
	
	Medico medicoEspecifico = (Medico) session.createCriteria (Medico.class)
							  .add(Restrictions.eq("id",id))
							  .uniqueResult();
	return medicoEspecifico;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DiasLaborales> buscarDiasLaborales(Long id) {
		
		final Session session = sessionFactory.getCurrentSession();
		
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
								 .add(Restrictions.like("id", usuario.getId()))
								 .uniqueResult();
		
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

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> getMedicos() {
		
		final Session session = sessionFactory.getCurrentSession();
		
		return session.createCriteria(Medico.class).list();
	}
	
	@Override
	public void guardarAtencion(String mensaje ,Long pacienteId, Long medicoId, String fecha) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Atencion atencion = new Atencion();
		
		Medico medico = (Medico) session.createCriteria (Medico.class)
				  		.add(Restrictions.eq("id",medicoId))
				  		.uniqueResult();
		
		Paciente paciente = (Paciente) session.createCriteria (Paciente.class)
				  			.add(Restrictions.eq("id",pacienteId))
				  			.uniqueResult();
		
		
		atencion.setTurno(null);
		atencion.setDescripcion(mensaje);
		atencion.setFecha(fecha);
		atencion.setPaciente(paciente);
		atencion.setMedico(medico);
		
		session.save(atencion);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Medico> listaMedicos(){
		
		final Session session = sessionFactory.getCurrentSession();
		
		List <Medico> listaMedicos = session.createCriteria(Medico.class)
									 .list();
		
		return listaMedicos;
	}

	@Override
	public Consultorio tieneConsultorio(Long medicoId) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		try {
			
		Consultorio consultorio = (Consultorio)session.createCriteria(Consultorio.class)
								  .add(Restrictions.like("medico.id", medicoId))
								  .uniqueResult();
		
		return consultorio;
		}
		
		catch(Exception e) {
			return null;
		}
		
	}

	@Override
	public void sacarConsultorio(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		
		Usuario usuarioBuscado = (Usuario) session.createCriteria(Usuario.class)
				 .add(Restrictions.like("id", id))
				 .uniqueResult();
		Long idMedico = usuarioBuscado.getMedico().getId();
		
		Consultorio consultorio = (Consultorio)session.createCriteria(Consultorio.class)
				  .add(Restrictions.like("medico.id", idMedico))
				  .uniqueResult();
		
		consultorio.setMedico(null);
		session.update(consultorio);
	}
	
}