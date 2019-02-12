package PrisonSchool.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Hello")
public class HelloController {

    @CrossOrigin
    @GetMapping("/Main")
    public String index() {
        return "\"We all worship dai kami sama\"";
    }
    //kommenteltem
}