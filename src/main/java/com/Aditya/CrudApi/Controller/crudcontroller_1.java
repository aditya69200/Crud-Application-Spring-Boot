package com.Aditya.CrudApi.Controller;

import com.Aditya.CrudApi.Entity.Student;
import com.Aditya.CrudApi.Service.StudentEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud1") // Updated to a more conventional naming style
public class crudcontroller_1 {

    @Autowired
    private StudentEntityService studentEntityService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentEntityService.getall();
    }

    @PostMapping
    public ResponseEntity<String> postEntry(@RequestBody Student student) {
        try {
            studentEntityService.SaveEntry(student);
            return ResponseEntity.ok("Student added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Failed to add student: " + e.getMessage());
        }
    }

    @DeleteMapping("/id/{id}")
    public void deleteEntry(@PathVariable String id) {
        studentEntityService.deleteone(id);
    }


}
