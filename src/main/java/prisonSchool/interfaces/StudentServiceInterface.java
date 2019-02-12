package prisonSchool.interfaces;

import prisonSchool.repository.entity.Student;

public interface StudentServiceInterface {
    Student getStudentById(int studentId);

    Student createStudent(Student student);
}
