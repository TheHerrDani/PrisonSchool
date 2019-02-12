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

    @PostMapping("/PostNewStudent")
    public @ResponseBody
    String getStudentById(@RequestParam String studentName) {
        //todo new student change to model layer student
        return studentService.createStudent(new Student(studentName));
    }

    @GetMapping("/GetStudentById")
    public @ResponseBody
    Student getStudentById(@RequestParam int studentId) {
        return studentService.getStudentById(studentId);
    }
}
