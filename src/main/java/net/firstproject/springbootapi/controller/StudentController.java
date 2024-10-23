package net.firstproject.springbootapi.controller;

import net.firstproject.springbootapi.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("students")
    private List<Student> getStudents(){
        ArrayList<Student> array = new ArrayList<>();

        for (int i = 0;i <10;i++){
            array.add(new Student(
                    i,
                    "Dan "+i,
                    "Lez"+i
            ));
        }
        return array;
    }

    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") int id){
        return new Student(id,"dan","lez");
    }

    @GetMapping("students/{id}/{firstName}/{lastName}")
    public Student studentPathVariableFull(@PathVariable("id") int id,
                                           @PathVariable("firstName") String firstName,
                                           @PathVariable("lastName") String lastName
    ){
        return new Student(id,firstName,lastName);
    }
}
