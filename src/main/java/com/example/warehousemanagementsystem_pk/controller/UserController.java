package com.example.warehousemanagementsystem_pk.controller;

import com.example.warehousemanagementsystem_pk.models.User;
import com.example.warehousemanagementsystem_pk.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<List<User>>(userService.allUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Integer id) {
        return new ResponseEntity<Optional<User>>(userService.getUser(id), HttpStatus.OK);
    }

}
