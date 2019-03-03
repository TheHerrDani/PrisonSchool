package prisonSchool.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import prisonSchool.domains.StudentDomain;
import prisonSchool.entities.StudentEntity;
import prisonSchool.exceptions.EntityNotFoundException;
import prisonSchool.interfaces.StudentMapper;
import prisonSchool.interfaces.StudentRepositoryInterface;
import prisonSchool.interfaces.StudentServiceInterface;

import java.util.Optional;
import java.util.function.Supplier;

@Service
public class StudentService implements StudentServiceInterface {


    private StudentRepositoryInterface studentRepository;
    private StudentMapper mapper = Mappers.getMapper(StudentMapper.class);

    @Autowired
    public StudentService(StudentRepositoryInterface studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDomain getStudentById(int studentId) {
        Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);
        return mapper.repositoryToService(optionalStudent.orElseThrow(() -> {
            throw new EntityNotFoundException(notFoundMessage(studentId));
        }));
    }

    @Override
    public StudentDomain createStudent(StudentDomain studentDomain) {
        StudentEntity studentEntity = mapper.serviceToRepository(studentDomain);
        return mapper.repositoryToService(studentRepository.save(studentEntity));
    }

    @Override
    public StudentDomain updateStudent(StudentDomain studentDomain) {
        int studentId = studentDomain.getStudentId();
        Optional<StudentEntity> optionalStudent = studentRepository.findById(studentId);
        optionalStudent.orElseThrow(() -> {
            throw new EntityNotFoundException(notFoundMessage(studentId));
        });     //így is lehet
        //optionalStudent.orElseThrow(NotFoundStudentExc);

        StudentEntity savedStudentEntity = studentRepository.save(mapper.serviceToRepository(studentDomain));
        return mapper.repositoryToService(savedStudentEntity);
    }

    private String notFoundMessage(int id){
       return String.format("Student with id: %d is not found.", id);
    }

    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }
}
