package ar.edu.unlam.tallerweb1.dao;

import java.util.List;
import javax.inject.Inject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Turno;

@Repository("buscadorPacientesDao")

public class BuscadorPacientesDaoImpl implements BuscadorPacientesDao {
	
	@Inject
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List <Paciente> listaPacientes(Long dni) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		List <Paciente> listaPacientes = session.createCriteria(Paciente.class)
		.add(Restrictions.like("dni",dni))
		.list();
		
		return listaPacientes;
	}
	
	@Override
	public boolean modificarEstadoTurno(Long id) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Turno miturno = new Turno();
		miturno = buscarTurnoPorId(id);
		
		miturno.setEstado("Abonado");
		session.update(miturno);
		return true;
	}
	
	@Override
	public boolean modificarEstadoTurnoRechazado(Long id) {
		
		final Session session = sessionFactory.getCurrentSession();
		
		Turno miturno = new Turno();
		miturno = buscarTurnoPorId(id);
		
		miturno.setEstado("rechazado");
		session.update(miturno);
		return true;
	}
	
	@Override
	public Turno buscarTurnoPorId(Long id) {
		final Session session = sessionFactory.getCurrentSession();
		
		Turno turnoBuscado = (Turno) session.createCriteria (Turno.class)
		.add(Restrictions.like("id",id)).uniqueResult();
		
		return (Turno) turnoBuscado;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List <Turno> listaTurnos(Long id){
		
		final Session session = sessionFactory.getCurrentSession();
		
		List <Turno> listaTurnos = session.createCriteria(Turno.class)
		.createAlias("paciente","pacienteBuscado")
		.add(Restrictions.like("pacienteBuscado.id",id)).add(Restrictions.like("estado","en_espera"))
		.addOrder(Order.asc("fecha"))
		.addOrder(Order.asc("horario"))
		.list();
		
		return listaTurnos;
	}

	
}
