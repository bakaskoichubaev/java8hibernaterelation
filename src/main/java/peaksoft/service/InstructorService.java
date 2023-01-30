package peaksoft.service;

import peaksoft.models.Instructor;
import peaksoft.repository.InstructorRepository;
import peaksoft.repository.impl.InstructorRepositoryImpl;

import java.util.List;

public class InstructorService implements InstructorRepository {
    private InstructorRepository instructorRepository = new InstructorRepositoryImpl();
    @Override
    public String saveInstructor(Instructor instructor) {
        instructorRepository.saveInstructor(instructor);
        return "save instructor";

    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        instructorRepository.updateInstructor(id, new Instructor());

    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public List<Instructor> getInstructorByCourseId(Long course_id) {
        return instructorRepository.getInstructorByCourseId(course_id);
    }

    @Override
    public void deleteInstructorById(Long id) {
        instructorRepository.deleteInstructorById(id);

    }

    @Override
    public void assignInstructorToCourse(Long id, Long course_id) {
        instructorRepository.assignInstructorToCourse(id,course_id);

    }
}
