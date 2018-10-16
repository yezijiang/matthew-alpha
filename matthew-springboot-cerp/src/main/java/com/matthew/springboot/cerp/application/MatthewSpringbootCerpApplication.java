package com.matthew.springboot.cerp.application;

import com.matthew.springboot.cerp.dto.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@PropertySource("classpath:project.properties")
@Controller
@SpringBootApplication
//核心注解，
public class MatthewSpringbootCerpApplication {
    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "Hello Spring Boot,mybook name is"+bookName;
    }

    @RequestMapping("/index")
    public String index(Model model){
        Person single = new Person("aa",11);

        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("xx",11);
        Person p2 = new Person("bb",22);
        Person p3 = new Person("cc",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MatthewSpringbootCerpApplication.class);
        app.setBannerMode(Banner.Mode.CONSOLE);
        app.run(args);
    }
}
