package sg.edu.nus.iss.vttp5_day16l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<String> students = studentRepo.getList(redisKey);
        return null;
    }

    
}
