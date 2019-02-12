package prisonSchool.service;

import prisonSchool.repository.entity.Student;

public interface StudentService {
    Student getStudentById(int studentId);

    String createStudent(Student student);
}
