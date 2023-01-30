package peaksoft.repository;

import peaksoft.models.Task;

import java.util.List;

public interface TaskRepository{
    void saveTask(Task task, Long lesson);

    void updateTask(Long TaskId, Task newTask);
    List<Task> getAllTaskByLessonId(Long id);

    void deleteByTaskId(Long id);
}
