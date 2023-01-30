package peaksoft.configuration;

import jakarta.persistence.EntityManager;
import org.hibernate.cfg.Configuration;
import peaksoft.models.Course;
import peaksoft.models.Instructor;
import peaksoft.models.Lesson;
import peaksoft.models.Task;

import static org.hibernate.cfg.AvailableSettings.*;

public class HibernateConfiguration {
    public static EntityManager getEntityManager() {
        Configuration configuration = new Configuration();
        configuration.setProperty(DRIVER, "org.postgresql.Driver");
        configuration.setProperty(URL, "jdbc:postgresql://localhost:5432/postgres");
        configuration.setProperty(USER, "postgres");
        configuration.setProperty(PASS, "1234");
        configuration.setProperty(HBM2DDL_AUTO, "update");
        configuration.setProperty(DIALECT, "org.hibernate.dialect.PostgreSQL9Dialect");
        configuration.setProperty(SHOW_SQL, "true");
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Task.class);
        return configuration.buildSessionFactory().createEntityManager();

    }
}
