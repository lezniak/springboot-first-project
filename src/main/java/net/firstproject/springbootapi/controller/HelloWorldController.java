package net.firstproject.springbootapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody//automatyczne serializowanie do jsona i ustawianie w httpresponse
@RestController //kombinacja tych dwoch
public class HelloWorldController {

    @GetMapping("/hello-world")
    public String helloWorld(){
        return "HW";
    }
}
