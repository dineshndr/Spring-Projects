package com.example.dockerdatabase.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class StudentController {
    @RequestMapping("/getStudents")
    public List<Student> getStudents()
    {
       return List.of(new Student(1,"Dinesh",26),
        new Student(2, "Divya", 28),
        new Student(3,"damu", 25));
    }
}
