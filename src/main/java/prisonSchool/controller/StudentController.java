package prisonSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prisonSchool.domains.StudentDomain;
import prisonSchool.interfaces.StudentServiceInterface;

@RestController
@RequestMapping("/StudentEntity")
public class StudentController {
    @Autowired
    private StudentServiceInterface studentService;

    @GetMapping("/GetStudentById")
    public StudentDomain getStudentById(@RequestParam int studentId) {
        //todo new student change to model layer student
        StudentDomain studentDomain =  studentService.getStudentById(studentId);
        return studentDomain;
    }

    @PostMapping("/AddNewStudent")
    public String addNewStudent(@RequestBody StudentDomain student) {
        StudentDomain studentDomain = studentService.createStudent(student);
        return String.format("Our application save a studentEntity with id: %d name: %s ", studentDomain.getStudentId(), studentDomain.getName());
    }

    @PutMapping("/updateStudent")
    public StudentDomain updateStudent(@RequestBody StudentDomain student){
        //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot found");
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/deleteStudent")
    public void deleteStudent(@RequestParam int studentId){
        studentService.deleteStudent(studentId);
    }
}
