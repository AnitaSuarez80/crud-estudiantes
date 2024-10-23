package com.example.crudstudents.service;

import java.util.List;
import com.example.crudstudents.entity.Student;


public interface StudentService {

    public List<Student> getStudents();

    public Student getStudent(Long id);

    public Student saveOrUpdate(Student student);

    public void delete(Long id);
    
}
