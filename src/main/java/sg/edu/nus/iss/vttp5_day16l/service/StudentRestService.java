package sg.edu.nus.iss.vttp5_day16l.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.JsonObject;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import sg.edu.nus.iss.vttp5_day16l.model.Student;

@Service
public class StudentRestService {
    
    RestTemplate restTemplate = new RestTemplate();

    private static final String studentUrl= "http://localhost:3000/api/students";


    public List<Student> getAllStudents(){
        
        // restTemplate.getForEntity(studentUrl, Student.class); // response type maps to student class which is also automapping, automaps into a student object for us?
        ResponseEntity<String> data = restTemplate.getForEntity(studentUrl, String.class);

        // Day 16 - slide 9 & 7 (API call thru restTemplate?), UI Controller will call?
        JsonReader jReader = Json.createReader(new StringReader(data.toString()));
        JsonObject jsonObj = jReader.readObject();
        
        Set<Entry<String, JsonValue>> entries = jsonObj.entrySet();

        List<Student> students = new ArrayList<>();

        for (Entry<String, JsonValue> entry : entries)
        {
            Student s = new Student();

            s.setId(Integer.parseInt(entry.getValue().asJsonObject().getString("id")));
            s.setFullName(entry.getValue().asJsonObject().getString("fullName"));
            s.setEmail(entry.getValue().asJsonObject().getString("email"));
            s.setPhoneNumber(entry.getValue().asJsonObject().getString("phoneNumber"));

            students.add(s);
        }
        
        return students;
    }
}
