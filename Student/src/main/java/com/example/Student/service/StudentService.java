package com.example.Student.service;
import com.example.Student.models.Student;
import com.example.Student.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private StudentRepo stdRepo;

    public StudentRepo getStdRepo() {
        return stdRepo;
    }

    @Autowired
    public void setStdRepo(StudentRepo stdRepo) {
        this.stdRepo = stdRepo;
    }
    public void addStudents(Student s){
        stdRepo.save(s);
    }
    public List<Student> getStudents(){
        return stdRepo.findAll();
    }
}
