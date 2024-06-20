package com.example.springjdbc.Student.Service;

import com.example.springjdbc.Student.DAO.StudentDAO;
import com.example.springjdbc.Student.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public  class StudentService {



    @Autowired
    public StudentDAO studentdao;

    public StudentDAO getStudentdao() {
        return studentdao;
    }
    @Autowired
    public void setStudentdao(StudentDAO studentdao) {
        this.studentdao = studentdao;
    }

    public void save(Student s)
    {
        studentdao.save(s);
    }

    public List<Student> findAllStudents(){
        return studentdao.findAllStudents();
    }




}
