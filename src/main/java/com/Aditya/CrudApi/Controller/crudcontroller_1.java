package com.Aditya.CrudApi.Controller;

import com.Aditya.CrudApi.Entity.Student;
import com.Aditya.CrudApi.Entity.User;
import com.Aditya.CrudApi.Service.StudentEntityService;
import com.Aditya.CrudApi.Service.UserEntityService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud1") // Updated to a more conventional naming style
public class crudcontroller_1 {

    @Autowired
    private StudentEntityService studentEntityService;

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentEntityService.getall();
    }

    @GetMapping("/{Username}")
    public ResponseEntity<?> getStudentbyname(@PathVariable String Username) {
        User user=userEntityService.Findbyname(Username);
        List<Student>all=user.getStudentEnteriesx();
        if(all!=null&&all.isEmpty())
        {
            return new ResponseEntity<>(all,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{username}")
    public ResponseEntity<?> addStudent(@RequestBody Student student,@PathVariable String username) {
          System.out.println(student);
            User user=userEntityService.Findbyname(username);
            studentEntityService.saveStudent(student,username);
            return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @PostMapping
   public ResponseEntity<?> addStudent(@RequestBody Student student) {
        System.out.println(student);
        studentEntityService.SaveEntry(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/id/{id}")
    public void deleteEntry(@PathVariable String id) {
        studentEntityService.deleteone(id);
    }

    @DeleteMapping("/{userName}/{myid}")
    public void deleteStudent(@PathVariable String userName,@PathVariable String myid) {
        studentEntityService.deletebyid(userName,myid);
    }

}
