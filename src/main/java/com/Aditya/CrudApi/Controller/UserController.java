package com.Aditya.CrudApi.Controller;

import com.Aditya.CrudApi.Entity.User;
import com.Aditya.CrudApi.Service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserEntityService userEntityService;

    @GetMapping
    public List<User> getUser() {
        return userEntityService.Alluser();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userEntityService.saveentry(user);
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> UpdateUser(@RequestBody User user,@PathVariable String username) {
       User userdb= userEntityService.Findbyname(username);
       if(userdb!=null) {
           userdb.setUsername(user.getUsername());
           userdb.setPassword(user.getPassword());
           userEntityService.saveentry(userdb);

       }
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
