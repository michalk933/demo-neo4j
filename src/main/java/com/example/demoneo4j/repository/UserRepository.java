package com.example.demoneo4j.repository;

import com.example.demoneo4j.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends Neo4jRepository<User, Long> {

    @Query("MATCH (u:User)<-[r:READ]-(b:Book) RETURN u,r,b")
    List<User> getAllUsers();

    @Query("MATCH (u:User {reader: {readerId}}) MATCH (u)<-[r:READ]-(b:Book) RETURN u,b,r")
    Optional<User> getUser(@Param("readerId") final String readerId);

    @Query("CREATE (:User {name: {userName}, reader: {readerId}})")
    Optional<User> createUser(@Param("userName") final String name, @Param("readerId") final String readerId);

    @Query("MATCH (u:User {reader: {readerId}}) DETACH DELETE u")
    void deleteUser(@Param("readerId") final String readerId);

    @Query("MATCH (u:User {reader: {readerId}}) SET u = {name:{userName}} RETURN u")
    Optional<User> updateName(
            @Param("readerId") final String readerId,
            @Param("userName") final String userName
    );

}
