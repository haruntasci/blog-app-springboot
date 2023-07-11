package com.haruntasci.springbootangularcrud.controller;

import com.haruntasci.springbootangularcrud.model.User;
import com.haruntasci.springbootangularcrud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    //Rest API CRUD

    //Create user
    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User user1 = userService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    //Read users
    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    //Get user by id
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    //Update user
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Long id) {
        return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
    }

    //Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
}
