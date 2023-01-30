package peaksoft.service;


import peaksoft.models.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.impl.CourseRepositoryImpl;

import java.util.List;

public class CourseService implements CourseRepository {
    private CourseRepository courseRepository = new CourseRepositoryImpl();

    @Override
    public String saveCourse(Course course) {
        courseRepository.saveCourse(course);
        return "save course";

    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public List<List<Course>> getAllCourse(String ascOrDesc) {
        return courseRepository.getAllCourse(ascOrDesc);
    }

    @Override
    public void updateCourse(Long courseId, Course course) {
        courseRepository.updateCourse(courseId,course);

    }

    @Override
    public void deleteCourseById(Long CourseId) {
        courseRepository.deleteCourseById(CourseId);

    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepository.getCourseByName(name);
    }
}