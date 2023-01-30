package peaksoft.service;

import peaksoft.models.Task;
import peaksoft.repository.TaskRepository;
import peaksoft.repository.impl.TaskRepositoryImpl;

import java.util.List;

public class TaskService implements TaskRepository {
    private TaskRepository taskRepository = new TaskRepositoryImpl();

    @Override
    public void saveTask(Task task, Long lesson) {
        taskRepository.saveTask(task, lesson);
    }



    @Override
    public void updateTask(Long id, Task task) {
        taskRepository.updateTask(id, task);

    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        return taskRepository.getAllTaskByLessonId(id);
    }

    @Override
    public void deleteByTaskId(Long id) {
        taskRepository.deleteByTaskId(id);

    }
}
