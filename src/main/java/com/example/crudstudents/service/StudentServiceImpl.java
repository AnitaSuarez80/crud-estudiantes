package com.example.crudstudents.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crudstudents.entity.Student;
import com.example.crudstudents.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id).get();
    }

    public Student saveOrUpdate(Student student){
        return studentRepository.save(student);
    }

    public void delete(Long id){
        studentRepository.deleteById(id);
    }

  

   

}


