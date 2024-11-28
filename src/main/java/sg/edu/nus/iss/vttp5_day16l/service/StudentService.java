package sg.edu.nus.iss.vttp5_day16l.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.json.JsonObject;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import sg.edu.nus.iss.vttp5_day16l.model.Student;
import sg.edu.nus.iss.vttp5_day16l.repository.ListRepo;

@Service
public class StudentService {
    
    @Autowired
    ListRepo studentRepo;

    // Write your CRUD functions here

    // add - convert students.tostring because else it is treated as an obj
    public void add(Student student) {
        studentRepo.rightPush("students", student.toString()); 
    }

    // findall - rediskey which is the key we store inside the DB
    public List<Student> findAll(String redisKey) {
        
        List<String> students = studentRepo.getList(redisKey); // students is the key containing all the JSON objects, which is a list of string stored
        List<Student> studentRecords = new ArrayList<>(); 

        // Using JSON-P to cast to list of students
        // JsonArrayBuilder jab = Json.createArrayBuilder(); 
        // ArrayBuilder must be outside the for loop

        // transfrom stringified student to Student obj
        for (String raw:students){ 
            String[] data = raw.split(",");

            /* // Day 16 - Slide 12
            JsonObject jsonObj = Json.createObjectBuilder()
                .add("id", Integer.parseInt(data[0]))
                .add("fullName", data[1])
                .add("email", data[2])
                .add("phoneNumber", data[3])
                .build();

            // Put JsonObject into Json Array - Reference day 16, slide 7
            jab.add(jsonObj); */

            Student s = new Student(Integer.parseInt(data[0]), data[1], data[2], data[3]);
            studentRecords.add(s);

        }

        // jab.build();

        return studentRecords;
    }

    
}
