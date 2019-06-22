package com.example.demoneo4j.model;


import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@Data
@NodeEntity
public class Categories {

    @Id
    private Long id;
    private String name;

    @Relationship(type = "TYPE", direction = Relationship.INCOMING)
    private List<Book> books;

}
