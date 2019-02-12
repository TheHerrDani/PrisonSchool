package prisonSchool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prisonSchool.interfaces.StudentRepository;
import prisonSchool.repository.entity.Student;

import java.util.Optional;

@Service
public class StudentService implements prisonSchool.interfaces.StudentService {

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
       return String.format("Our application save a student with id: %d name: %s ", student.getStudentId(), student.getName());
    }
}
