package prisonSchool.service;

import org.springframework.beans.factory.annotation.Autowired;
import prisonSchool.repository.StudentRepository;
import prisonSchool.repository.entity.Student;

import java.util.Optional;

public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student getStudentById(int studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        //todo what if we dont have anything in the optional?? Exception throwing??
        return optionalStudent.orElseGet(Student::new);
    }

    @Override
    public String createStudent(Student student) {
       studentRepository.save(student);
       return String.format("Our application save a student with id: %d name: %s ", student.getProductId(), student.getName());
    }
}
