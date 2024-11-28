package sg.edu.nus.iss.vttp5_day16l.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5_day16l.model.Student;

import org.springframework.web.bind.annotation.PostMapping;

// To serve the pages
@Controller
@RequestMapping("/students")
public class StudentController {
    
    @GetMapping("")
    public String studentForm(Model model) {
        Student s = new Student();
        model.addAttribute("student", s);
        
        return "studentform";
    }

    @PostMapping("")
    public String postStudentForm(@ModelAttribute Student entity) {

        return "redirect:/students/list";
    }

    @GetMapping("/list")
    public String getStudentList(Model model) {
        List<Student> students = new ArrayList<>(); // empty Array List
        model.addAttribute("students", students);
        
        return "studentlist";
    }
    
    
    
}
