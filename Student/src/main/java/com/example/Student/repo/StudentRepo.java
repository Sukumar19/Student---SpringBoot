package com.example.Student.repo;
import com.example.Student.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student s){
        String sql = "insert into Student(roll,name,marks) values(?,?,?)";
        int a=jdbc.update(sql,s.getRoll(),s.getName(),s.getMarks());
        System.out.println(a+"Added");
    }

    public List<Student> findAll(){
        List<Student> stds = new ArrayList<>();
        String sql="select * from Student";
        RowMapper<Student> mapper = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs , int rowNum) throws SQLException{
                Student stu = new Student();
                stu.setRoll(rs.getInt("roll"));
                stu.setName(rs.getString("name"));
                stu.setMarks(rs.getInt("marks"));
                return stu;
            }
        };
        return jdbc.query(sql,mapper);
    }
}
