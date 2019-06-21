package com.example.demoneo4j.model;

import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@Data
@NodeEntity
public class User {

    @Id
    private Long id;

    @Property(name = "reader")
    private String readerId;

    private String name;

    @Relationship(type = "READ", direction = Relationship.INCOMING)
    private List<Book> books;

}
