package com.jpa.test.controller;

import com.jpa.test.entities.Student;
import com.jpa.test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);

    }

    @PutMapping("/student/{studentid}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("studentid") int id) {
        return studentService.updateStudent(student, id);

    }

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();

    }

    @DeleteMapping("/student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") int id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/{studentemail}")
    public List<Student> getStudentEmail(@PathVariable("studentemail") String email) {
        return studentService.getStudentEmail();
    }

    @GetMapping("/find")
    public List<Student> findByEmailStartingWithPrefix(@RequestParam String prefix) {
        return studentService.findByEmailStartingWithPrefix(prefix);

    }

    @GetMapping("/finds")
    public List<Student> findByNameEndingWith(@RequestParam String suffix) {
        return studentService.findByNameEndingWith(suffix);
    }

    @GetMapping("/finding")
    public List<Student> findByNameContaining(@RequestParam String words) {
        return studentService.findByNameContaining(words);
    }

    @GetMapping("/all")
    public List<Student> getAllTheStudent() {
        return studentService.getAllTheStudent();
    }

    /*
    @GetMapping("/getall")
    public List<Student> getStudent(){
        return studentService.getStudent();
    }*/
  /*  @GetMapping("/getalls")
    public ResponseEntity<String> getStudentNotFound() {
        return new ResponseEntity<>("student not found", HttpStatus.NOT_FOUND);

    }*/


}


		



