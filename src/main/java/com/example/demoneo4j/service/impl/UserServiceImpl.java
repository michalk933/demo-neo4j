package com.example.demoneo4j.service.impl;

import com.example.demoneo4j.exception.Neo4jException;
import com.example.demoneo4j.model.User;
import com.example.demoneo4j.repository.UserRepository;
import com.example.demoneo4j.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<User> getUsersWithBook() {
        return repository.getAllUsersWithBooks();
    }

    public List<User> getUsers(){
        return repository.getAllUsers();
    }

    @Override
    public User getUser(final String readerId) {
        return repository.getUser(readerId)
                .orElse(new User());
    }

    @Override
    public void delete(final String readerId) {
        repository.deleteUser(readerId);
    }

    @Override
    public User updateName(final String readerId, final String newName) {
        return repository.updateName(readerId, newName)
                .orElseThrow(() -> new Neo4jException("Something wrong during update userName, for user: " + readerId));
    }

    @Override
    public User createUser(final String userName, final String readerId) {
        return repository.createUser(userName, readerId)
                .orElseThrow(() -> new Neo4jException("Something wrong during create new user, for user name: " + userName));
    }
}
