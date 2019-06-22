package com.example.demoneo4j.controller;


import com.example.demoneo4j.model.User;
import com.example.demoneo4j.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserServiceImpl service;

    @GetMapping("")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/books")
    public List<User> getUsersWithBook() {
        return service.getUsersWithBook();
    }

    @GetMapping("/{readerId}")
    public User getUser(@PathVariable("readerId") String readerId) {
        return service.getUser(readerId);
    }


    @DeleteMapping("/{readerId}")
    public void deleteUser(@PathVariable("readerId") final String readerId) {
        service.delete(readerId);
    }

    @PatchMapping()
    public User updateUser(
            @RequestParam("readerId") final String readerId,
            @RequestParam("name") final String name
    ) {
        return service.updateName(readerId, name);
    }

    @PostMapping
    public User createUser(
            @RequestParam("userName") final String userName,
            @RequestParam("readerId") final String readerId
    ) {
        return service.createUser(userName, readerId);
    }

}
