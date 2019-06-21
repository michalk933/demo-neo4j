package com.example.demoneo4j.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "READ")
public class Read {

    @Id
    @GeneratedValue
    private Long id;

    @Property
    private String readDate;

    @StartNode
    private User user;

    @EndNode
    private Book book;

}
