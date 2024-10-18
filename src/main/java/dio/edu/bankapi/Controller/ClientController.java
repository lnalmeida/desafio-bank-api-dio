package dio.edu.bankapi.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class UserController {
    @GetMapping("/hello")
    public String hello(){
        return "<h1>Hello world!</h1>";
    }
}
