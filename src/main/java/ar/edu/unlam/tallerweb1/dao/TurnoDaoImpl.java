package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;

@Repository("turnoDao")
public class TurnoDaoImpl implements TurnoDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void guardarTurno(Long especialidadId, Long medicoId, String horario) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Turno turno = new Turno();
		
		Especialidad especialidad = new Especialidad();
		
		Medico medico = new Medico();
		
		especialidad.setId(especialidadId);
		
		medico.setEspecialidad(especialidad);
		medico.setId(medicoId);
		
		turno.setHorario(horario);
		turno.setMedico(medico);
		
		session.save(turno);
		
	}

	@Override
	public List<Turno> listaTurnos() {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Turno> listaTurnos = session.createCriteria(Turno.class).list();
		//.add(Restrictions.like("Turno.medico", medicoId))
		
		return listaTurnos;
	}
	
	
	


}