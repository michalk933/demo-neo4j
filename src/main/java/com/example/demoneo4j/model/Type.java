package com.example.demoneo4j.model;

import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "TYPE")
public class Type {

    @Id
    private Long id;

    @Property
    private int rate;

    @StartNode
    private Categories categories;

    @EndNode
    private Book book;

}
