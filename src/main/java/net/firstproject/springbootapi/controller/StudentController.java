package net.firstproject.springbootapi.controller;

import net.firstproject.springbootapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("student")
    private Student getStudent(){
        return new Student(
                1,
                "Dan",
                "Lez"
        );
    }
}
