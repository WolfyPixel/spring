package org.itstep.studentsystem.service;

import org.itstep.studentsystem.entity.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudent();

    Student getStudent(Long id);

    Student updateStudent(Long id, Student student);


}