package prisonSchool.interfaces;

import prisonSchool.domains.StudentDomain;
import prisonSchool.entities.StudentEntity;

public interface StudentServiceInterface {
    StudentDomain getStudentById(int studentId);

    StudentDomain createStudent(StudentDomain studentDomain);

    StudentDomain updateStudent(StudentDomain studentDomain);

    void deleteStudent(int studentId);
}
