package peaksoft.repository.impl;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import peaksoft.configuration.HibernateConfiguration;
import peaksoft.models.Lesson;
import peaksoft.models.Task;
import peaksoft.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private static EntityManager entityManager = HibernateConfiguration.getEntityManager();
    @Override
    public void saveTask(Task task, Long lessonId) {
        List<Task> list = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            Lesson lesson = entityManager.find(Lesson.class, lessonId);
            list.addAll(lesson.getTasks());
            list.add(task);
            lesson.setTasks(list);
            entityManager.persist(lesson);
            entityManager.merge(lesson);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("save task");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }


    }

    @Override
    public void updateTask(Long TaskId, Task newTask) {
        try{
            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, newTask);
            task.setName(newTask.getName());
            task.setDeadLine(newTask.getDeadLine());
            task.setTask(newTask.getTask());
            entityManager.merge(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("update task");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        try{
            entityManager.getTransaction().begin();
            List<Lesson> list = entityManager.createQuery
                    ("select i from Lesson i where i.id = :id",Lesson.class )
                    .setParameter("id",id).getResultList();
            Lesson lesson = list.get(0);
            List<Task> task = new ArrayList<>(lesson.getTasks());
            System.out.println("get task by lesson id");
        return task;
    }catch (HibernateException e) {
            throw new RuntimeException();
        }
        }

    @Override
    public void deleteByTaskId(Long id) {
        try{
            entityManager.getTransaction().begin();
            Task task = entityManager.find(Task.class, id);
            entityManager.remove(task);
            entityManager.getTransaction().commit();
            entityManager.close();
            System.out.println("delete by task id");
        }catch (HibernateException e){
            System.out.println(e.getMessage());
        }

    }


}
