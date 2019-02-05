package PrisonSchool.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/Main")
    public String index() {
        return "We all worship dai kami sama";
    }

}