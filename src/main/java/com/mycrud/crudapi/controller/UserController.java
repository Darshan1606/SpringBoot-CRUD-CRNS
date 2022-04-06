package com.mycrud.crudapi.controller;

import com.mycrud.crudapi.model.User;
import com.mycrud.crudapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/user")
    public ResponseEntity<?> createNewUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return new ResponseEntity<Object>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long userId) {
        User user = userService.findUserById(userId);
        if (user == null) {
            MessageResponse messageResponse = new MessageResponse();
            messageResponse.setMessage("User not found.");
            return new ResponseEntity<Object>(messageResponse, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Object>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = userService.findAllUsers();
        return new ResponseEntity<Object>(userList, HttpStatus.OK);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        user.setUserId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<Object>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("User has been deleted successfully.");
        return new ResponseEntity<Object>(messageResponse, HttpStatus.OK);
    }
}
