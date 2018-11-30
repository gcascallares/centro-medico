package ar.edu.unlam.tallerweb1.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.modelo.Atencion;
import ar.edu.unlam.tallerweb1.modelo.DiasLaborales;
import ar.edu.unlam.tallerweb1.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.modelo.Estudio;
import ar.edu.unlam.tallerweb1.modelo.Medico;
import ar.edu.unlam.tallerweb1.modelo.Turno;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.modelo.Paciente;

@Repository("turnoDao")
public class TurnoDaoImpl implements TurnoDao {
	
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Turno guardarTurno (Turno turno, Long idUsuario) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Usuario usuario = (Usuario)session.createCriteria(Usuario.class)
						  .add(Restrictions.like("id", idUsuario))
						  .uniqueResult();
		
		turno.setEstado("En espera");
		turno.setPaciente(usuario.getPaciente());
		
		session.save(turno);
		
		return turno;
	}
	
	@Override
	public void guardarTurnoRecepcionista(Turno turno) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		turno.setEstado("En espera");
		turno.setDerivado(0);
		
		session.save(turno);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Turno> listaTurnosPorMedico(Medico medico, String diaActual) {
		
		Session session = sessionFactory.getCurrentSession();
		
		List <Turno> listaTurnos = session.createCriteria(Turno.class)
		.createAlias("medico","medicoBuscado")
		.add(Restrictions.like("medicoBuscado.id", medico.getId()))
		.add(Restrictions.like("fecha", diaActual))
		.add(Restrictions.like("estado", "Abonado"))
		.addOrder(Order.asc("horario"))
		.list();
		
		return listaTurnos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> turnosDisponibles(List<String> listaTurnos, Long especialidadId, Long medicoId, String fecha) {
		
		Session session = sessionFactory.getCurrentSession();
		
		List<Turno> listaTurnosBD = session.createCriteria(Turno.class).list();
		
		for(Turno turno : listaTurnosBD) {
			if(turno.getFecha()!= null && turno.getFecha().equals(fecha) && turno.getMedico().getId() == medicoId &&
					turno.getMedico().getEspecialidad().getId() == especialidadId) {
				if(turno.getHorario() != null && listaTurnos.contains(turno.getHorario())) {
					listaTurnos.remove(turno.getHorario());
				}
			}
		}
		
		return listaTurnos;
	}

	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Atencion> mostrarHistoriaClinica(Long id){
		
		final Session session = sessionFactory.getCurrentSession();
		
		List <Atencion> listaHistorial = session.createCriteria(Atencion.class)
				.createAlias("paciente","pacienteJoin")
				.add(Restrictions.like("pacienteJoin.id", id))
				.list();
		
		return listaHistorial;
	}
	
	@Override
	public Paciente mostrarDatosPaciente(Long id) {
		
	final Session session = sessionFactory.getCurrentSession();
	
	Paciente paciente = (Paciente) session.createCriteria(Paciente.class)
			.add(Restrictions.eq("id",id))
			.uniqueResult();
	
	return paciente;
	}

	@Override
	public void cambiarEstadoAtendido(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		
		Turno turno = (Turno)session.createCriteria(Turno.class)
					  .add(Restrictions.like("id", id))
		              .uniqueResult();
		
		turno.setEstado("Atendido");
		session.update(turno);
	}

	@Override
	public void agregarDescripcion(Long turnoId,String descripcion, Long estudioId) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Estudio estudio = (Estudio)session.createCriteria(Estudio.class)
				  		  .add(Restrictions.like("id", estudioId))
				          .uniqueResult();
	
		Turno turno = (Turno)session.createCriteria(Turno.class)
					  .add(Restrictions.like("id", turnoId))
					  .uniqueResult();
		
		Paciente paciente = turno.getPaciente();
		
		turno.setEstudio(estudio);
		
		Atencion atencion = new Atencion();
		
		atencion.setTurno(turno);
		atencion.setDescripcion(descripcion);
		atencion.setPaciente(paciente);
		atencion.setFecha(turno.getFecha());
		atencion.setMedico(turno.getMedico());
		
		session.save(atencion);
		
		session.update(turno);
	}

	@Override
	public void agregarDerivacion(Long pacienteId, Long idMedico) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Paciente paciente = (Paciente)session.createCriteria(Paciente.class)
		  		  .add(Restrictions.like("id", pacienteId))
		          .uniqueResult();
		
		Medico medico = (Medico)session.createCriteria(Medico.class)
		  		  .add(Restrictions.like("id", idMedico))
		          .uniqueResult();
		
		Turno turno = new Turno();
		
		turno.setEstado("En espera");
		turno.setDerivado(1);
		turno.setPaciente(paciente);
		turno.setMedico(medico);
		
		session.save(turno);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List <Turno> listaDeDerivacion(Long usuarioId) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Paciente paciente = (Paciente) session.createCriteria(Paciente.class)
							.add(Restrictions.like("id", usuarioId))
							.uniqueResult();
		
		
		List <Turno> listaDeDerivaciones = session.createCriteria(Turno.class)
				  .createAlias("paciente", "pacienteBuscado")
				  .add(Restrictions.like("pacienteBuscado.id", paciente.getId()))
				  .add(Restrictions.like("derivado", 1))
				  .list();
		
		return listaDeDerivaciones;

	}
	
	@Override
	public Turno guardarDerivacion (Long turnoId, String fecha, String horario ,Long especialidadId, Long medicoId) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Turno turno = (Turno) session.createCriteria(Turno.class)
					  .add(Restrictions.like("id", turnoId))
					  .uniqueResult();
		
		Especialidad especialidad = (Especialidad) session.createCriteria(Especialidad.class)
								    .add(Restrictions.like("id", especialidadId))
								    .uniqueResult();
		
		Medico medico = (Medico) session.createCriteria(Medico.class)
			            .add(Restrictions.like("id", medicoId))
			            .uniqueResult();
		
		
		medico.setEspecialidad(especialidad);
		
		turno.setMedico(medico);
		turno.setDerivado(0);
		turno.setFecha(fecha);
		turno.setHorario(horario);
		
		session.update(turno);
		
		return turno;
	}

	@Override
	public List<Turno> listaTodosLosTurnos(Medico medico) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		List <Turno> listaTodosLosTurnos = session.createCriteria(Turno.class)
					.createAlias("medico","medicoBuscado")
				  .add(Restrictions.like("medicoBuscado.id", medico.getId()))
				  .add(Restrictions.not(Restrictions.like("estado","Abonado")))
				  .add(Restrictions.not(Restrictions.like("estado","Rechazado")))
				  .add(Restrictions.isNotNull("fecha"))
				  .addOrder(Order.asc("fecha"))
				  .list();
		
		
		return listaTodosLosTurnos;
		
	}

	@Override
	public List<Turno> listaTurnosProxDiaLaboral(Medico medico, String diaSiguiente) {

		final Session session = sessionFactory.getCurrentSession();
		
		List <Turno> listaTurnosProxDiaLaboral = session.createCriteria(Turno.class)
				.createAlias("medico","medicoBuscado")
				.add(Restrictions.like("medicoBuscado.id", medico.getId()))
				.add(Restrictions.like("fecha", diaSiguiente))
				.add(Restrictions.like("estado", "En espera"))
				.addOrder(Order.asc("horario"))
				.list();
		
		return listaTurnosProxDiaLaboral;
	}
	

}