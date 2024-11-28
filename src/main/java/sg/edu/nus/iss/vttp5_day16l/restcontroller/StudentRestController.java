package sg.edu.nus.iss.vttp5_day16l.restcontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.JsonObject;
import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import sg.edu.nus.iss.vttp5_day16l.constant.Constant;
import sg.edu.nus.iss.vttp5_day16l.model.Student;
import sg.edu.nus.iss.vttp5_day16l.service.StudentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/api/students", produces = "application/json")
public class StudentRestController {
    
    @Autowired
    StudentService studentService;

    @PostMapping(path = {"", "/create"})
    public ResponseEntity<String> create(@RequestBody Student entity) {

        studentService.add(entity);
        
        // return new ResponseEntity("true", HttpStatus.OK); // Darryl method
        return ResponseEntity.ok().body("true"); // ok is a status code, returning a body, string data (Slides method)
    }

    // @GetMapping("")
    // // public ResponseEntity<List<Student>> findAll(){ 
    //     List<Student> students = studentService.findAll(Constant.studentKey);
    //     return ResponseEntity.ok().body(students);
    // }

    @GetMapping("")
    public ResponseEntity<String> findAll(){

        List<Student> students = studentService.findAll(Constant.studentKey);

        JsonArrayBuilder jsonArray = Json.createArrayBuilder();

        for (Student s : students)
        {
            JsonObject jsonObj = Json.createObjectBuilder()
                .add("id", s.getId())
                .add("fullName", s.getFullName())
                .add("email", s.getEmail())
                .add("phoneNumber", s.getPhoneNumber())
                .build();

                Json

        }
    
}
