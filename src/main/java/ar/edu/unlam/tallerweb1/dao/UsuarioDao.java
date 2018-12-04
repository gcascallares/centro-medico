package ar.edu.unlam.tallerweb1.dao;

<<<<<<< HEAD
import ar.edu.unlam.tallerweb1.modelo.Usuario;

// Interface que define los metodos del DAO de Usuarios.
public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);

	void guardarUsuario(Usuario usuario);
=======
import ar.edu.unlam.tallerweb1.modelo.Paciente;
import ar.edu.unlam.tallerweb1.modelo.Usuario;

public interface UsuarioDao {
	
	Usuario consultarUsuario (Usuario usuario);

	Usuario guardarUsuario(Paciente paciente);
>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git

	Usuario consultarUsuario(Long idUsuario);
}
