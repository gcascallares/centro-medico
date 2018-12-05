package ar.edu.unlam.tallerweb1.dao;

import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return (Usuario) session.createCriteria(Usuario.class)
			   .add(Restrictions.eq("dni", usuario.getDni()))
			   .add(Restrictions.eq("password", usuario.getPassword()))
			   .uniqueResult();
	}
	
	@Override
	public Usuario guardarUsuario (Paciente paciente) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Usuario usuario = new Usuario();
		
		usuario.setDni(paciente.getDni());
		usuario.setPaciente(paciente);
		usuario.setRol("paciente");
		
		session.save(usuario);
		
		return usuario;
		
	}

	@Override
	public Usuario consultarUsuario(Long idUsuario) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Usuario usuario = (Usuario)session.createCriteria(Usuario.class)
						  .add(Restrictions.like("id", idUsuario))
						  .uniqueResult();
		
		return usuario;
	}

}
