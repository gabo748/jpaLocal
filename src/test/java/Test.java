import org.apache.logging.log4j.*;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

    static Logger log = LogManager.getRootLogger();
    public static void main(String[] args) {
        // crearEstudiante();
        // recuperarPorId();
        // actualizarEstudiante();
        // eliminarEstudiante();
    }

    public static void crearEstudiante() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Estudiante estudiante = new Estudiante(2, "EC100521", "Angie", "Espinoza");
        em.persist(estudiante);
        tx.commit();
        log.debug("Objeto" + estudiante);
        em.close();
    }

    public static void recuperarPorId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Estudiante estudiante = em.find(Estudiante.class, 3);
        tx.commit();
        System.out.println("Objecto" + estudiante);
        em.close();
    }

    private static void actualizarEstudiante() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Estudiante estudiante = em.find(Estudiante.class, 3);
        tx.commit();
        System.out.println("Objeto Recuperado" + estudiante);

        estudiante.setNombres("Karla");

        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();

        em.merge(estudiante);
        tx2.commit();
        System.out.println("Objeto" + estudiante);
        em.close();
    }

    private static void eliminarEstudiante() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EstudiantePU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // INICIAMOS TRANSACCION

        Estudiante estudiante = em.find(Estudiante.class, 3);
        tx.commit();
        System.out.println("Object " + estudiante);

        EntityTransaction tx2 = em.getTransaction();
        tx2.begin();

        em.remove(em.merge(estudiante));
        tx2.commit();
        System.out.println("Objeto" + estudiante);
        em.close();
    }


}
