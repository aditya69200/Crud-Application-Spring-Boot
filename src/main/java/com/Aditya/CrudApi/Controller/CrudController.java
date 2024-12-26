package com.Aditya.CrudApi.Controller;

import com.Aditya.CrudApi.Entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Crud") // Ensure it starts with a "/"
public class CrudController {

    private Map<Integer, Student> studentEntries = new HashMap<>();

    // GET: Retrieve all students
    @GetMapping
    public List<Student> getStudents() {
        return new ArrayList<>(studentEntries.values());
    }

    // POST: Add a student
//    @PostMapping
//    public ResponseEntity<List<Student>> postStudents(@RequestBody List<Student> students) {
//        students.forEach(student -> studentEntries.put(student.getId(), student));
//        return ResponseEntity.ok(students);  // Return all added students with HTTP 200 status
//    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student student = studentEntries.get(id);
        if (student == null) {
            return ResponseEntity.notFound().build(); // Return 404 if the student is not found
        }
        return ResponseEntity.ok(student); // Return 200 with the student object if found
    }


}
