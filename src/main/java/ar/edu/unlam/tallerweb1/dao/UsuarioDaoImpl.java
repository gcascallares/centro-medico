package ar.edu.unlam.tallerweb1.dao;

<<<<<<< HEAD
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

// implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	// Como todo dao maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		
		Session session = sessionFactory.getCurrentSession();
		return (Usuario) session.createCriteria(Usuario.class)
				.add(Restrictions.eq("dni", usuario.getDni()))
				.add(Restrictions.eq("password", usuario.getPassword()))
				.uniqueResult();
	}
	
	@Override
	public void guardarUsuario (Usuario usuario) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(usuario);
=======
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

// implelemtacion del DAO de usuarios, la anotacion @Repository indica a Spring que esta clase es un componente que debe
// ser manejado por el framework, debe indicarse en applicationContext que busque en el paquete ar.edu.unlam.tallerweb1.dao
// para encontrar esta clase.
@Repository("usuarioDao")
public class UsuarioDaoImpl implements UsuarioDao {

	// Como todo dao maneja acciones de persistencia, normalmente estará inyectado el session factory de hibernate
	// el mismo está difinido en el archivo hibernateContext.xml
	@Inject
    private SessionFactory sessionFactory;

	@Override
	public Usuario consultarUsuario(Usuario usuario) {

		// Se obtiene la sesion asociada a la transaccion iniciada en el servicio que invoca a este metodo y se crea un criterio
		// de busqueda de Usuario donde el email y password sean iguales a los del objeto recibido como parametro
		// uniqueResult da error si se encuentran más de un resultado en la busqueda.
		
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
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
		
	}

	@Override
	public Usuario consultarUsuario(Long idUsuario) {
		Session session = sessionFactory.getCurrentSession();
		Usuario usuario = (Usuario)session.createCriteria(Usuario.class)
		.add(Restrictions.like("id", idUsuario)).uniqueResult();
		
		return usuario;
	}

}
