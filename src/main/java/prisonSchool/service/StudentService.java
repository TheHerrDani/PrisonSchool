package prisonSchool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prisonSchool.exceptions.EntityNotFoundException;
import prisonSchool.interfaces.StudentRepositoryInterface;
import prisonSchool.interfaces.StudentServiceInterface;
import prisonSchool.repository.entity.Student;

import java.util.Optional;
import java.util.function.Supplier;

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

    public Student updateStudent(int studentId, String studentName){
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        String message = String.format("Nincs %s tipusú, %d Id-jű entity", Student.class.getSimpleName(), studentId);
        optionalStudent.orElseThrow(() -> {throw new EntityNotFoundException(message);});     //így is lehet
        //optionalStudent.orElseThrow(NotFoundStudentExc);

        Student student = optionalStudent.get();
        student.setName(studentName);
        studentRepository.save(student);
        return student;
    }

    private Supplier NotFoundStudentExc = () -> {throw new EntityNotFoundException("nincs ilyen student");};

    public void deleteStudent(int studentId){
        studentRepository.deleteById(studentId);
    }
}
