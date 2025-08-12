package com.example.jv250211_md04_session05.controllers;

import com.example.jv250211_md04_session05.models.entity.StudentDTO;
import com.example.jv250211_md04_session05.models.entity.Students;
import com.example.jv250211_md04_session05.repositori.StudentDAO;
import com.example.jv250211_md04_session05.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;


    @GetMapping
    public String findAll(Model model){
        model.addAttribute("students" , studentService.findAll());
        return "students";
    }

    @GetMapping("/addStudent")
    public String showAddStudent(Model model){
        model.addAttribute("student" , new StudentDTO());
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute StudentDTO studentDTO){
        studentService.save(studentDTO);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditStudent(@PathVariable("id") int id, Model model){
        Students student = studentService.findById(id);
        model.addAttribute("student" , studentService.convertStudenttoStudentDTO(student));
        model.addAttribute("id" , id);
        return "updateStudent";
    }

    @PostMapping("/edit/{id}")
    public String editStudent(@ModelAttribute StudentDTO studentDTO,
                              @PathVariable("id") int id){
        studentService.update(studentDTO,id);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        studentService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "search") String search,
                         @RequestParam(name = "sort",defaultValue = "ASC") String sort,
                         Model model){
        List<Students> students = studentService.searchStudentByName(search, sort);
        model.addAttribute("students", students);
        model.addAttribute("search", search);
        model.addAttribute("sort" , sort);
        return "students";
    }

}
