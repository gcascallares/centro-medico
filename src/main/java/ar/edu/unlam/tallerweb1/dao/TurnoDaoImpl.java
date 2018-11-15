package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;

@Repository("turnoDao")
public class TurnoDaoImpl implements TurnoDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public void guardarTurno (Turno turno) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		session.save(turno);
		
	}

	@Override
	public List<Turno> listaTurnosPorMedico(Medico medico, String diaActual) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List <Turno> listaTurnos = session.createCriteria(Turno.class)
		.createAlias("medico","medicoBuscado")
		.add(Restrictions.like("medico.id", medico.getId()))
		.add(Restrictions.like("fecha", diaActual))
		.add(Restrictions.like("estado", "en_espera"))
		.list();
		
		return listaTurnos;
	}

	@Override
	public List<String> turnosDisponibles(List<String> listaTurnos, Long especialidadId, Long medicoId, String fecha) {
		Session session = sessionFactory.getCurrentSession();
		List<Turno> listaTurnosBD = session.createCriteria(Turno.class).list();
		
		for(Turno turno : listaTurnosBD) {
			if(turno.getFecha().equals(fecha) && turno.getMedico().getId() == medicoId &&
					turno.getMedico().getEspecialidad().getId() == especialidadId) {
				if(listaTurnos.contains(turno.getHorario())) {
					listaTurnos.remove(turno.getHorario());
				}
			}
		}
		return listaTurnos;
	}

	@Override
	public List<DiasLaborales> listaDeDiasDisponibles(Long especialidadId) {
		//lista de los dias de los medicos que trabajan en esa especialidad
		final Session session = sessionFactory.getCurrentSession();
		List <DiasLaborales> lista = session.createCriteria(DiasLaborales.class)
		.createAlias("Medicos", "Medicos")
		.createAlias("Medicos.especialidad", "especialidadBuscada")
		.add(Restrictions.eq("especialidadBuscada.id",especialidadId)).list();
		
		return lista;
	}
	
	@Override
	public List<Medico> listaDeMedicosDisponibles (Long especialidadId , Long diaId) {
		//lista de los dias de los medicos que trabajan en esa especialidad
		final Session session = sessionFactory.getCurrentSession();
		List <Medico> lista = session.createCriteria(Medico.class)
		.createAlias("especialidad","especialidadBuscada")
		.add(Restrictions.eq("especialidadBuscada.id", especialidadId))
		.createAlias("diasLaborales", "diasBuscados")
		.add(Restrictions.eq("diasBuscados.id", diaId))
		.list();
		
		return lista;
	}
	
	
	


}