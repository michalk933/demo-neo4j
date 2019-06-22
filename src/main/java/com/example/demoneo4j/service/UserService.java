package com.example.demoneo4j.service;

import com.example.demoneo4j.model.User;

import java.util.List;

public interface UserService {

    /**
     * Method return all user with books
     *
     * @return users
     */
    List<User> getUsersWithBook();

    /**
     * Method return user by id
     *
     * @param readerId reader id
     * @return user
     */
    User getUser(final String readerId);

    /**
     * Method delete user
     *
     * @param readerId reader id
     */
    void delete(final String readerId);

    /**
     * Method update user name or throw exception Neo4jException
     *
     * @param readerId reader id
     * @param newName new name
     * @return user
     */
    User updateName(final String readerId, final String newName);

    /**
     * Method create new User or throw exception Neo4jException
     *
     * @param userName user name
     * @return user
     */
    User createUser(final String userName, final String readerId);

    /**
     * Method return all users
     *
     * @return users
     */
    List<User> getUsers();
}
