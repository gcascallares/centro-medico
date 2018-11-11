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

	@Override
	public List<String> turnosDisponibles(List<String> listaTurnos, Long especialidadId, Long medicoId, String fecha) {
		Session session = sessionFactory.getCurrentSession();
		List<Turno> listaTurnosBD = session.createCriteria(Turno.class).list();
		
		for(Turno turno : listaTurnosBD) {
			if(turno.getFecha() == fecha && turno.getMedico().getId() == medicoId &&
					turno.getMedico().getEspecialidad().getId() == especialidadId) {
				if(listaTurnos.contains(turno.getHorario())) {
					listaTurnos.remove(turno.getHorario());
				}
			}
		}
		return listaTurnos;
	}
	
	
	


}