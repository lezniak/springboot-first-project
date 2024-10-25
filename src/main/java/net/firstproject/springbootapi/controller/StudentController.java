package net.firstproject.springbootapi.controller;

import net.firstproject.springbootapi.bean.Student;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    private ResponseEntity<Student> getStudent() {
        Student student = new Student(
                1,
                "Dan",
                "Lez"
        );
        //return new ResponseEntity<Student>(student,HttpStatus.OK);
        return ResponseEntity.ok().header("Custom-header", "test").body(student);
    }

    @GetMapping("students")
    private ResponseEntity<List<Student>> getStudents() {
        ArrayList<Student> array = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            array.add(new Student(
                    i,
                    "Dan " + i,
                    "Lez" + i
            ));
        }
        return ResponseEntity.ok(array);
    }

    @GetMapping("students/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int id) {
        return ResponseEntity.ok(new Student(id, "dan", "lez"));
    }

    @GetMapping("students/{id}/{firstName}/{lastName}")
    public ResponseEntity<Student> studentPathVariableFull(@PathVariable("id") int id,
                                           @PathVariable("firstName") String firstName,
                                           @PathVariable("lastName") String lastName
    ) {
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    @GetMapping("students/query")
    public ResponseEntity<Student> studentRequestVariable(@RequestParam int id,
                                          @RequestParam("firstName") String firstName,
                                          @RequestParam("lastName") String lastName) {
        return ResponseEntity.ok(new Student(id, firstName, lastName));
    }

    @PostMapping("students/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        System.out.println(student.ToString());
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }


    @PutMapping("students/{id}/update")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,
                                 @PathVariable("id") int id) {
        System.out.println(id + student.ToString());
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("students/{id}/delete")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return new ResponseEntity<>("Delete completed",HttpStatus.OK);
    }
}
