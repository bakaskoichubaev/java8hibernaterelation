package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import peaksoft.configuration.HibernateConfiguration;
import peaksoft.models.Course;
import peaksoft.repository.CourseRepository;

import java.util.ArrayList;
import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    EntityManager entityManager = HibernateConfiguration.getEntityManager();

    @Override
    public String saveCourse(Course course) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("Save course");
        } catch (HibernateException e) {
            System.out.println((e.getMessage()));
        }
        return "save course";

    }

    @Override
    public Course getCourseById(Long courseId) {
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, courseId);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("get course");
            return course;
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public List<List<Course>> getAllCourse(String ascOrDesc) {
        List<List<Course>> returnList = new ArrayList<>();
        try {
            switch (ascOrDesc) {
                case "asc" ->{
                    entityManager.getTransaction().begin();
                    List<Course> coursesAsc = entityManager.createQuery
                            ("select c from Course c order by c.createAt asc", Course.class).getResultList();
                    entityManager.getTransaction().commit();
                    entityManager.close();
                    System.out.println("get all course asc");
                    returnList.add(coursesAsc);
                }
                case "desc" -> {
                    entityManager.getTransaction().begin();
                    List<Course> courseDesc = entityManager.createQuery
                            ("select c from Course c order by c.createAt desc ",Course.class).getResultList();
                    entityManager.getTransaction().commit();
                    entityManager.close();
                    System.out.println("get all course desc");
                    returnList.add(courseDesc);
                }
            }
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
        return returnList;
    }

    @Override
    public void updateCourse(Long courseId, Course newCourse) {
        try {
            entityManager.getTransaction().begin();
            Course course1 = entityManager.find(Course.class, courseId);
            course1.setDuration(newCourse.getDuration());
            course1.setCreateAt(newCourse.getCreateAt());
            course1.setImageLink(newCourse.getImageLink());
            course1.setDescription(newCourse.getDescription());
            entityManager.merge(course1);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("update course");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public void deleteCourseById(Long CourseId) {
        try {
            entityManager.getTransaction().begin();
            Course course = entityManager.find(Course.class, getCourseById(1L));
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("delete course");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());

        }

    }

    @Override
    public Course getCourseByName(String name) {
        try {
            entityManager.getTransaction().begin();
            List<Course> list = entityManager.createQuery
                    ("select c from Course c", Course.class).getResultList();
            entityManager.getTransaction().commit();
            for (Course c : list) {
                if (getCourseByName(name).equals(name)) {

                return c;
            }
        }
        return null;
    }catch(
    HibernateException e){


        throw new RuntimeException();

    }}
}

