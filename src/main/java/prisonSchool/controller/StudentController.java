package prisonSchool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prisonSchool.interfaces.StudentServiceInterface;
import prisonSchool.repository.entity.Student;

@RestController
@RequestMapping("/Student")
public class StudentController {
    @Autowired
<<<<<<< HEAD
    private StudentService studentService;

<<<<<<< HEAD:src/main/java/prisonSchool/controller/HelloController.java
    @CrossOrigin
=======
>>>>>>> HelloController to StudentController:src/main/java/prisonSchool/controller/StudentController.java
    @GetMapping("/Main")
    public String index() {
        return "\"We all worship dai kami sama\"";
    }
<<<<<<< HEAD:src/main/java/prisonSchool/controller/HelloController.java
    //kommenteltem
}
=======
=======
    private StudentServiceInterface studentService;
>>>>>>> Rename interfaces and implementation

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
>>>>>>> HelloController to StudentController:src/main/java/prisonSchool/controller/StudentController.java
