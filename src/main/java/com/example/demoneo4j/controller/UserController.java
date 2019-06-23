package com.example.demoneo4j.controller;


import com.example.demoneo4j.model.User;
import com.example.demoneo4j.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
class UserController {


    private final UserService service;

    @GetMapping("")
    public List<User> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/books")
    public List<User> getUsersWithBook() {
        return service.getUsersWithBook();
    }

    @GetMapping("/{readerId}")
    public User getUser(@PathVariable("readerId") @Valid @NotBlank String readerId) {
        return service.getUser(readerId);
    }


    @DeleteMapping("/{readerId}")
    public void deleteUser(@PathVariable("readerId") @Valid @NotBlank final String readerId) {
        service.delete(readerId);
    }

    @PatchMapping()
    public User updateUser(
            @RequestParam("readerId") @Valid @NotBlank final String readerId,
            @RequestParam("name") @Valid @NotBlank final String name
    ) {
        return service.updateName(readerId, name);
    }

    @PostMapping
    public User createUser(
            @RequestParam("userName") @Valid @NotBlank final String userName,
            @RequestParam("readerId") @Valid @NotBlank final String readerId
    ) {
        return service.createUser(userName, readerId);
    }

}
