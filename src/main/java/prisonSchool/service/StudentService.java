package prisonSchool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prisonSchool.interfaces.StudentRepositoryInterface;
import prisonSchool.interfaces.StudentServiceInterface;
import prisonSchool.repository.entity.Student;

import java.util.Optional;

@Service
public class StudentService implements StudentServiceInterface {

    @Autowired
    private StudentRepositoryInterface studentRepository;

    @Override
    public Student getStudentById(int studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        //todo what if we dont have anything in the optional?? Exception throwing??
        return optionalStudent.orElseGet(Student::new);
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
}
