package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class MyApplication {

    @RequestMapping({"/","/home"} )
    String home() {
        return "Welcome Home!";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}


