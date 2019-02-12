package prisonSchool.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Student")
public class StudentController {

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

    @GetMapping("/getStudentById")
    public String getStudentById() {
        return "We all worship dai kami sama";
    }
}
>>>>>>> HelloController to StudentController:src/main/java/prisonSchool/controller/StudentController.java
