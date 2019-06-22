package com.example.demoneo4j.repository;

import com.example.demoneo4j.model.Read;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface ReadRelationshipRepository extends Neo4jRepository<Read, Long> {

    @Query("MATCH (u:User {reader: {readerId}}) MATCH (b:Book) WHERE ID(b)={bookId} CREATE (b)-[:READ {date: {date}}]->(u)")
    void addReadRelation(
            @Param("readerId") final String readerId,
            @Param("bookId") final long bookId,
            @Param("date") final LocalDate date
    );

}