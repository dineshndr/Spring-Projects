package com.example.springjdbc.Student;

import com.example.springjdbc.Student.Model.Student;
import com.example.springjdbc.Student.Service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(StudentApplication.class, args);
		Student s = context.getBean(Student.class);
		s.setAge(21);
		s.setName("ku");
		s.setMarks(31);

		s.setAge(221);
		s.setName("2eku");
		s.setMarks(312);



		StudentService serve = context.getBean(StudentService.class);
//		System.out.println(serve.getStudent(s));
     	serve.save(s);
		List<Student> students = serve.findAllStudents();
		System.out.println(students);



	}



}
