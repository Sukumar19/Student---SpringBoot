package com.example.Student;

import com.example.Student.models.Student;
import com.example.Student.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(StudentApplication.class, args);
		Student s1 = context.getBean(Student.class);
		s1.setName("Sukumar");
		s1.setMarks(100);
		s1.setRoll(103);
		System.out.println(s1.getName());
		StudentService stdSer = context.getBean(StudentService.class);
		stdSer.addStudents(s1);
		System.out.println(stdSer.getStudents());
	}

}
