package com.example.crudstudents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.crudstudents.entity.Student;
import com.example.crudstudents.service.StudentService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {

@Autowired
private StudentService studentService;

@GetMapping({"/students", "/"})
public String getAllStudents(Model model){
    model.addAttribute("students", studentService.getStudents());
    return "students";
}


@GetMapping("/new/student")
public String newStudent (Model model){
    Student student = new Student();
    model.addAttribute("student", student);
    return "create_student";
}
@PostMapping("/students")
public String saveOrUpdate(@ModelAttribute("student") Student student){
    studentService.saveOrUpdate(student);
    return "redirect:/students";
}
 
@GetMapping("/students/edit/{id}")
public String formEdit(@PathVariable Long id, Model model){
    model.addAttribute("student", studentService.getStudent(id));
    return "edit_student";
}

@PostMapping("/students/{id}")
public String saveOrUpdate(@PathVariable Long id, @ModelAttribute("student") Student student, Model model){
    Student registeredStudent = studentService.getStudent(id);
    registeredStudent.setId(id);
    registeredStudent.setNames(student.getNames());
    registeredStudent.setFirst_last_name(student.getFirst_last_name());
    registeredStudent.setSecond_last_name(student.getSecond_last_name());
    registeredStudent.setEmail(student.getEmail());
    registeredStudent.setAge(student.getAge());
    studentService.saveOrUpdate(registeredStudent);
    return "redirect:/students";
}

@GetMapping("/students/{id}")
public String delete(@PathVariable Long id){
    studentService.delete(id);
    return "redirect:/students";
}

}
