package peaksoft.repository;

import peaksoft.models.Course;

import java.util.List;

public interface CourseRepository {
    String saveCourse(Course course);
    Course getCourseById(Long courseId);
    List<List<Course>> getAllCourse(String ascOrDesc);
    void updateCourse(Long courseId, Course course);
    void deleteCourseById(Long CourseId);
    Course getCourseByName(String name);
}
