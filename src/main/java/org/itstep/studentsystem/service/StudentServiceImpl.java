package org.itstep.studentsystem.service;

import org.itstep.studentsystem.entity.Student;
import org.itstep.studentsystem.repo.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student addStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return repository.findAll();
    }

    @Override
    public Student getStudent(Long id) {
        return repository.getById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return repository.findById(id).map(i -> {
            i.setFirstName(student.getFirstName());
            i.setLastName(student.getLastName());
            i.setGpa(student.getGpa());
            return repository.save(i);
        }).orElseGet(() ->{
            student.setId(id);
            return  repository.save(student);
        });
    }


}