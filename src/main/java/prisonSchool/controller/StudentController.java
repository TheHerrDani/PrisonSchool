package prisonSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prisonSchool.interfaces.StudentServiceInterface;
import prisonSchool.repository.entity.Student;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
    private StudentServiceInterface studentService;

    @GetMapping("/GetStudentById")
    public Student getStudentById(@RequestParam int studentId) {
        //todo new student change to model layer student
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/AddNewStudent")
    public String addNewStudent(@RequestParam String studentName) {
        Student student = studentService.createStudent(new Student(studentName));
        return String.format("Our application save a student with id: %d name: %s ", student.getStudentId(), student.getName());
    }
}
