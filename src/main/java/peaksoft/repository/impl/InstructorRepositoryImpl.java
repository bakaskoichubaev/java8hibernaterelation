package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import peaksoft.configuration.HibernateConfiguration;
import peaksoft.models.Course;
import peaksoft.models.Instructor;
import peaksoft.repository.InstructorRepository;

import java.util.ArrayList;
import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository {
    private static EntityManager entityManager = HibernateConfiguration.getEntityManager();
    @Override
    public String saveInstructor(Instructor instructor) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("save instructor");
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public void updateInstructor(Long id, Instructor newInstructor) {
        try {
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, id);
            instructor.setFirstName(newInstructor.getFirstName());
            instructor.setLastName(newInstructor.getLastName());
            instructor.setEmail(newInstructor.getEmail());
            instructor.setPhoneNumber(newInstructor.getPhoneNumber());
            instructor.setCourse(newInstructor.getCourse());
            entityManager.merge(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("update instructor");
        }catch(HibernateException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Instructor getInstructorById(Long instructorId) {
        try {
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("get instructor by id");
            return instructor;
        }catch (HibernateException e){
            throw new RuntimeException();
        }
    }


    @Override
    public List<Instructor> getInstructorByCourseId(Long id) {
            try {
                entityManager.getTransaction().begin();
                List<Course> courses = entityManager.createQuery("select c from Course c.id = :id", Course.class).
                        setParameter("id", id).getResultList();
                Course course = courses.get(0);
                List<Instructor> instructors = new ArrayList<>(course.getInstructors());
                System.out.println("get instructor by course id");
                return instructors;
            }catch (HibernateException e){
                throw new RuntimeException();
            }
        }

    @Override
    public void deleteInstructorById(Long instructorId) {
        try {
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            entityManager.remove(instructor);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("delete instructor by id");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        try {
            entityManager.getTransaction().begin();
            Instructor instructor = entityManager.find(Instructor.class, instructorId);
            Course course = entityManager.find(Course.class, courseId);
            instructor.getCourse().add(course);
            entityManager.merge(instructor);
            entityManager.merge(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("assign instructor to course");
        }catch (HibernateException e){
            System.out.println(e.getMessage());

        }

    }
}
