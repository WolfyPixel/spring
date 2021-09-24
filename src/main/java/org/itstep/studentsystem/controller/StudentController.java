package org.itstep.studentsystem.controller;

import org.itstep.studentsystem.entity.Student;
import org.itstep.studentsystem.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @ResponseBody
    @GetMapping("/")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> allStudent = studentService.getAllStudent();
        return new ResponseEntity<>(allStudent, HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable ("id") Long id){
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

}
