package peaksoft.service;

import peaksoft.models.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.repository.impl.LessonRepositoryImpl;

import java.util.List;

public class LessonService implements LessonRepository {
    private LessonRepository lessonRepository = new LessonRepositoryImpl();
    @Override
    public String saveLesson(Lesson lesson, Long courseId) {
        lessonRepository.saveLesson(lesson, courseId);
       return "save lesson";
    }

    @Override
    public void updateLesson(Long lessonId, Lesson newLesson, Long courseId) {
        lessonRepository.updateLesson(lessonId, newLesson, courseId);

    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepository.getLessonById(id);
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long id) {
        return lessonRepository.getLessonByCourseId(id);
    }
}
