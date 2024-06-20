package com.example.springjdbc.Student.DAO;

import com.example.springjdbc.Student.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Student> findAllStudents() {
        String sql = "select * from student";
        //List<Student> student = new ArrayList<>();
        RowMapper<Student> mapper = (rs, rowNum) -> {
            Student s = new Student();
            s.setAge(rs.getInt("age"));
            s.setMarks(rs.getInt("marks"));
            s.setName(rs.getString("name"));
            return s;
        };

        return jdbc.query(sql, mapper);
    }

    public void save(Student s) {
        //System.out.println("Added successfully");
        String sql = "insert into student (age, name, marks) values (?, ?, ?)";
        int rows = jdbc.update(sql, s.getAge(), s.getName(), s.getMarks());
        System.out.println(rows + " affected");
    }

}
