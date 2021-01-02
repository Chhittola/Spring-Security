package com.security.demoSpringSecurity.student;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "James Bond"),
            new Student(2, "Maria Jones"),
            new Student(3, "Anna Smith")
    );
    @GetMapping
    public List<Student> getStudents() {
        return STUDENTS;
    }
    @PostMapping
    public Student registerStudent(@RequestBody Student student) {
        return student;
    }
    @PutMapping
    public void update(@RequestBody Student student) {
        System.out.println(student.getStudentId() + "\t" + student.getStudentName());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        System.out.println(id);
    }
}
