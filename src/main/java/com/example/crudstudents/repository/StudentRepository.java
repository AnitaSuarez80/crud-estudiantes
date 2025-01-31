package com.example.crudstudents.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crudstudents.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
