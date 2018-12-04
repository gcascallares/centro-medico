package ar.edu.unlam.tallerweb1;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

<<<<<<< HEAD
// Se indica que los test que hereden de esta clase corran con el runner de junit para spring.
@RunWith(SpringJUnit4ClassRunner.class)
// Se indica
@ContextConfiguration(locations = {"/test-applicationContext.xml"})
// Clase base para los test que se pretende que se corran dentro del contexto de spring
public abstract class SpringTest {

    // Tiene inyectado el session factory para que los test que hereden de éste tengan acceso al mismo
    @Inject
    private SessionFactory sessionFactory;

    // Metodo para obtener una sesion de base de datos
=======
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/test-applicationContext.xml"})

public abstract class SpringTest {

    @Inject
    private SessionFactory sessionFactory;

>>>>>>> branch 'master' of https://github.com/ignacrescenzo/centro-medico.git
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

}
